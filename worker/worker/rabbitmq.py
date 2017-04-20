from pika import SelectConnection

class RabbitMQConsumer():
    def __init__(self, options = {}):
        self.options = options
        self.connection = SelectConnection(on_open_callback= self.on_connected)

    def on_connected(self, connection):
        self.connection = connection
        self.connection.channel(self.on_channel_open)

    def on_channel_open(self, new_channel):
        self.channel = new_channel
        self.channel.queue_declare(queue=self.options['queue'],
            durable=self.options['durable'], exclusive=self.options['exclusive'],
            auto_delete=self.options['auto_delete'],
            callback=self.on_queue_declared)

    def on_queue_declared(self, frame):
        self.channel.basic_consume(self.handle_delivery, queue=self.options['queue'])

    def handle_delivery(self, channel, method, header, body):
        self.options['on_receive'](body)

    def start(self):
        self.connection.ioloop.start()

    def stop(self):
        self.connection.close()

