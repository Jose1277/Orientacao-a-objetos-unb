import math
from my_libraries.entidades import *
from my_libraries.Quadrilateros import *

ponto_a = Ponto(0, 0)
ponto_b = Ponto(10, 0)
ponto_c = Ponto(10, 10)
ponto_d = Ponto(0, 10)
#mostra a distancia entre o ponto a e o ponto b

print("Distancia entre os pontos a e b:")
print(ponto_a.distancia_de(ponto_c))
#mostra o quadrante do ponto a
print(ponto_a.quadrante())
#mostra o ponto a
print(ponto_a)
print("\n")

#cria uma reta entre os pontos a e b
reta_ab = Reta(ponto_a, ponto_b)
#mostra o comprimento da reta ab
print("Comprimento da reta ab:")
print(reta_ab.calcula_comprimento())
print("\n")

#cria um triangulo retângulo com vertices a, b e c
triangulo_abc = Triangulo(ponto_a, ponto_b, ponto_c)
#mostra a area do triangulo abc
print("Area do triangulo abc:")
print(triangulo_abc.area())
print("\n")

#cria um circulo de raio 5 e centro em (0, 0)
circulo = Circulo(ponto_a, 5)
#mostra a area do circulo com centro em a e raio 5
print("Area do circulo com centro em a e raio 5:")
print(circulo.area())
print("\n")

#cria um quadrado com vertices a, b, c e d
quadrado = Quadrado(ponto_a, ponto_b, ponto_c, ponto_d)
#mostra a area do quadrado abcd
print("Area do quadrado abcd:")
print(quadrado.area())
print("\n")

#troca os pontos a, b, c, d para formar um trapézio
ponto_c = Ponto(7, 10)
ponto_d = Ponto(3, 10)
#cria um trapézio com vertices a, b, c e d
trapezio = Trapezio(ponto_a, ponto_b, ponto_c, ponto_d)
#mostra a area do trapézio abcd
print("Area do trapezio abcd:")
print(trapezio.area())
print("\n")

#troca os pontos a, b, c, d para formar um retângulo
ponto_c = Ponto(10, 5)
ponto_d = Ponto(0, 5)
#cria um retângulo com vertices a, b, c e d
retangulo = Retangulo(ponto_a, ponto_b, ponto_c, ponto_d)
#mostra a area do retângulo abcd
print("Area do retangulo abcd:")
print(retangulo.area())
print("\n")

#troca os pontos a, b, c, d para formar um losango
ponto_a = Ponto(0, 0)
ponto_b = Ponto(10, 10)
ponto_c = Ponto(20, 0)
ponto_d = Ponto(10, -10)
#cria um losango com vertices a, b, c e d
losango = Losango(ponto_a, ponto_b, ponto_c, ponto_d)
#mostra a area do losango abcd
print("Area do losango abcd:")
print(losango.area())
