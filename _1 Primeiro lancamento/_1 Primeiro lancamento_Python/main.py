import math

class Ponto:
    def __init__(self, x, y):
        self.x = x
        self.y = y


class Reta:
    def __init__(self, ponto_a, ponto_b):
        self.ponto_1 = ponto_a
        self.ponto_2 = ponto_b
        
    def calcula_comprimento(self):
        return ((self.ponto_1.x - self.ponto_2.x)**2 + (self.ponto_1.y - self.ponto_2.y)**2)**0.5
        
class Triangulo:
    def __init__(self, ponto_a, ponto_b, ponto_c):
        self.ponto_1 = ponto_a
        self.ponto_2 = ponto_b
        self.ponto_3 = ponto_c
        self.reta_ab = Reta(ponto_a, ponto_b)
        self.reta_bc = Reta(ponto_b, ponto_c)    
        self.reta_ca = Reta(ponto_c, ponto_a)
        
    def area(self):
        p = (self.reta_ab.calcula_comprimento() + self.reta_bc.calcula_comprimento() + self.reta_ca.calcula_comprimento())/2
        return (p*(p-self.reta_ab.calcula_comprimento())*(p-self.reta_bc.calcula_comprimento())*(p-self.reta_ca.calcula_comprimento()))**0.5
    
class Circulo:
    def __init__(self, centro, raio):
        self.centro = centro
        self.raio = raio
        
    def area(self):
        return math.pi*self.raio**2
    
class Quadrilatero:
    def __init__(self, ponto_a, ponto_b, ponto_c, ponto_d):
        self.ponto_1 = ponto_a
        self.ponto_2 = ponto_b
        self.ponto_3 = ponto_c
        self.ponto_4 = ponto_d
        self.reta_ab = Reta(ponto_a, ponto_b)
        self.reta_bd = Reta(ponto_b, ponto_d)    
        self.reta_dc = Reta(ponto_d, ponto_c)
        self.reta_ca = Reta(ponto_c, ponto_a)
        
    def area(self):
        return self.reta_ab.calcula_comprimento() * self.reta_bd.calcula_comprimento()

ponto_a = Ponto(0, 0)
ponto_b = Ponto(10, 0)
ponto_c = Ponto(0, 10)
ponto_d = Ponto(10, 10)

#cria uma reta entre os pontos a e b
reta_ab = Reta(ponto_a, ponto_b)
#mostra o comprimento da reta ab
print(reta_ab.calcula_comprimento())

#cria um triangulo retangulo com vertices a, b e c
triangulo_abc = Triangulo(ponto_a, ponto_b, ponto_c)
#mostra a area do triangulo abc
print(triangulo_abc.area())

#cria um circulo de raio 5 e centro em (0, 0)
circulo = Circulo(ponto_a, 5)
#mostra a area do circulo com centro em a e raio 5
print(circulo.area())

#cria um quadrado com vertices a, b, c e d
quadrilatero = Quadrilatero(ponto_a, ponto_b, ponto_c, ponto_d)
#mostra a area do quadrado abcd
print(quadrilatero.area())