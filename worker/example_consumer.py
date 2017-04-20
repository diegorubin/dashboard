from worker.consumer import Consumer

class ExampleConsumer(Consumer):
    def on_receive(self, payload):
        print(payload)

consumer = ExampleConsumer({
    'type': 'RabbitMQConsumer',
    'params' : {
        'queue': 'example',
        'durable': True,
        'exclusive': False,
        'auto_delete': False
    }
})

consumer.start()

