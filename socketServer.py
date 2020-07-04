import socketserver
import RPi.GPIO as GPIO
import time
import random

GPIO.setmode(GPIO.BOARD)
GPIO.setup(7, GPIO.OUT)
p = GPIO.PWM(7,50)
p.start(7.5)

class MyTCPHandler(socketserver.BaseRequestHandler):
    """
    The request handler class for our server.

    It is instantiated once per connection to the server, and must
    override the handle() method to implement communication to the
    client.
    """

    def handle(self):
        # self.request is the TCP socket connected to the client
        self.data = self.request.recv(1024).decode("utf-8").strip()
        print(self.data)
        self.stepper(self.data, p)

    def stepper(self, data, p):
        print("stepper "+str(data))
        try:
            if data=="0":
                p.ChangeDutyCycle(2.5)
            elif data == "90":
                p.ChangeDutyCycle(7.5)
            elif data == "180":
                p.ChangeDutyCycle(12.5)
            else:
#                Randomize
                p.ChangeDutyCycle(14)
                time.sleep(2)
                p.ChangeDutyCycle(random.uniform(2.5, 12.5))
        except KeyboardInterrupt:
            p.stop()
            GPIO.cleanup()

if __name__ == "__main__":
    HOST, PORT = "YOUR-IP-ADDRESS", 1223


    with socketserver.TCPServer((HOST, PORT), MyTCPHandler) as server:
        # Activate the server; this will keep running until you
        # interrupt the program with Ctrl-C
        try:
            server.serve_forever()
        except KeyboardInterrupt:
            server.shutdown()
