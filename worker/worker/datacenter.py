import json
from urllib import request

def send_order_to_datacenter(source, payload):
    payload['source'] = source
    body = json.dumps(payload).encode('utf8')
    req = request.Request('http://localhost:8080/orders', data=body,
        headers={'content-type': 'application/json'})
    response = request.urlopen(req)
    print(response)
    print(response.read().decode('utf8'))

