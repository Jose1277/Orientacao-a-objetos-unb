import math

class Ponto:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def distancia_de(self, ponto):
        return ((self.x - ponto.x)**2 + (self.y - ponto.y)**2)**0.5
    
    def quadrante(self):
        if(self.x > 0 and self.y > 0):
            return "Primeiro quadrante"
        if(self.x < 0 and self.y > 0):
            return "Segundo quadrante"
        if(self.x < 0 and self.y < 0):
            return "Terceiro quadrante"
        if(self.x > 0 and self.y < 0):
            return "Quarto quadrante"
        if(self.x == 0 and self.y == 0):        
            return "Origem"
        if(self.x == 0 and self.y != 0):
            return "Eixo Y"
        if(self.x != 0 and self.y == 0):
            return "Eixo X"
        
    def setPonto(self, x, y):
        self.x = x
        self.y = y
     
    def __str__(self):
        return "({},{})".format(self.x, self.y)

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
        self.reta_bc = Reta(ponto_b, ponto_c)    
        self.reta_cd = Reta(ponto_c, ponto_d)
        self.reta_da = Reta(ponto_d, ponto_a)
        
    def distancia_retas_paralelas(self):
        return self.reta_cd.ponto_1.y - self.reta_ab.ponto_1.y
    