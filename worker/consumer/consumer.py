from rabbitmq import RabbitMQConsumer

class Consumer():
    def __init__(self, options = {}):
        self.__worker = self.__init_worker__(options)
        pass

    def run(self):
        pass

    def __init_worker__(self, options):
        return getattr(options['type'])(options['params'])

