from pika import SelectConnection

class RabbitMQConsumer():
    def __init__(self, options = {}):
        self.connection = SelectConnection()

    def on_connected(connection):
        connection.channel(on_channel_open)

    def on_channel_open(new_channel):
        """Called when our channel has opened"""
        channel = new_channel
        channel.queue_declare(queue="test", durable=True, exclusive=False, auto_delete=False, callback=on_queue_declared)

    def on_queue_declared(frame):
        """Called when RabbitMQ has told us our Queue has been declared, frame is the response from RabbitMQ"""
        channel.basic_consume(handle_delivery, queue='test')

    def handle_delivery(channel, method, header, body):
        """Called when we receive a message from RabbitMQ"""
        print body

