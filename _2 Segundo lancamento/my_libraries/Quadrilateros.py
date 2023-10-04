from my_libraries.entidades import Quadrilatero, Reta

class Quadrado(Quadrilatero):
    def __init__(self, ponto_a, ponto_b, ponto_c, ponto_d):
        super().__init__(ponto_a, ponto_b, ponto_c, ponto_d)
        self.reta_ab = Reta(ponto_a, ponto_b)
        self.reta_bc = Reta(ponto_b, ponto_c)
        self.reta_cd = Reta(ponto_c, ponto_d)
        self.reta_da = Reta(ponto_d, ponto_a)
        
    def area(self):
        return self.reta_ab.calcula_comprimento()**2
    
class Retangulo(Quadrilatero):
    def __init__(self, ponto_a, ponto_b, ponto_c, ponto_d):
        super().__init__(ponto_a, ponto_b, ponto_c, ponto_d)
        self.reta_ab = Reta(ponto_a, ponto_b)
        self.reta_bc = Reta(ponto_b, ponto_c)
        self.reta_cd = Reta(ponto_c, ponto_d)
        self.reta_da = Reta(ponto_d, ponto_a)
        
    def area(self):
        return self.reta_ab.calcula_comprimento()*self.reta_bc.calcula_comprimento()
    
class Trapezio(Quadrilatero):
    def __init__(self, ponto_a, ponto_b, ponto_c, ponto_d):
        super().__init__(ponto_a, ponto_b, ponto_c, ponto_d)
        self.reta_ab = Reta(ponto_a, ponto_b)
        self.reta_bc = Reta(ponto_b, ponto_c)
        self.reta_cd = Reta(ponto_c, ponto_d)
        self.reta_da = Reta(ponto_d, ponto_a)
    
    def area(self):
        return (self.reta_ab.calcula_comprimento() + self.reta_cd.calcula_comprimento())*self.distancia_retas_paralelas()/2
    
class Losango(Quadrilatero):
    def __init__(self, ponto_a, ponto_b, ponto_c, ponto_d):
        super().__init__(ponto_a, ponto_b, ponto_c, ponto_d)
        self.reta_ab = Reta(ponto_a, ponto_b)
        self.reta_bc = Reta(ponto_b, ponto_c)
        self.reta_cd = Reta(ponto_c, ponto_d)
        self.reta_da = Reta(ponto_d, ponto_a)
        
    def calcula_diagonal(self, ponto_a, ponto_c):
        return ponto_a.distancia_de(ponto_c)
    
    def area(self):
        return self.calcula_diagonal(self.ponto_1, self.ponto_3)*self.calcula_diagonal(self.ponto_2, self.ponto_4)/2
    
class Paralelogramo(Quadrilatero):
    def __init__(self, ponto_a, ponto_b, ponto_c, ponto_d):
        super().__init__(ponto_a, ponto_b, ponto_c, ponto_d)
        self.reta_ab = Reta(ponto_a, ponto_b)
        self.reta_bc = Reta(ponto_b, ponto_c)
        self.reta_cd = Reta(ponto_c, ponto_d)
        self.reta_da = Reta(ponto_d, ponto_a)
        
    def area(self):
        return self.reta_ab.calcula_comprimento()*self.distancia_retas_paralelas()