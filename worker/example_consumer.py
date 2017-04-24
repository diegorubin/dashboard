import json

from worker.consumer import Consumer
from worker.datacenter import send_order_to_datacenter

class ExampleConsumer(Consumer):
    def on_receive(self, payload):
        print('received: %s'%(payload))
        try:
            payload_in_json = json.loads(payload.decode('utf8'))
            send_order_to_datacenter('example', payload_in_json)
        except Exception as e:
            print(str(e))

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

