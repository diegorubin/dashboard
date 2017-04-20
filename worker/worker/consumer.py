import sys

from abc import abstractmethod
from worker.rabbitmq import RabbitMQConsumer

class Consumer():
    def __init__(self, options = {}):
        self.__worker = self.__init_worker__(options)

    @abstractmethod
    def on_receive(self, body):
        pass

    def start(self):
        try:
            self.__worker.start()
        except KeyboardInterrupt:
            self.__worker.stop()

    def __init_worker__(self, options):
        options['params']['on_receive'] = self.on_receive
        return getattr(sys.modules[__name__], 'RabbitMQConsumer')(options['params'])

