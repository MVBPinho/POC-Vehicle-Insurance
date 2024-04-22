# POC - Sistema que verifica o melhor veículo para o cliente
Foi realizado o desenvolvimento de uma POC para seguro veicular. O sistema recebe alguns dados enviados pelo sistema que o cliente preenche
será realizado uma verificação de qual o melhor seguro para ofertar para o cliente.

## Regra de negócio
### categoria do veículo
- Clientes que possuem o valor do carro igual ou inferior a R$ 70000.00 (valor <= 70000) estará na categoria 1
- Clientes que possuem o valor do carro entre R$ 70000.01 e R$ 99999.99 (valor > 70000 && valor < 100000) estará na categoria 2
- Clientes que possuem o valor do carro igual ou superior a R$ 100000.00 (valor >= 100000) estará na categoria 3

### Tipo do seguro
- Existem 3 tipos de seguros que podem ser ofertados para os clientes:
- BASICO - O seguro básico tem um valor de 2% do valor do veículo.
- PARCIAL - O seguro parcial tem um valor de 3% do valor do veículo.
- TOTAL - O seguro total tem um valor de 4% do valor do veículo.

#### Categoria 1
- O cliente pode ter os seguros básico ou parcial, dependendo da sua localidade e idade.
* Se o cliente morar em São Paulo (SP) e tiver menos de 30 anos, ele poderá ter o seguro parcial.
* Se o cliente não atender às duas condições acima ele terá o seguro básico.

#### Categoria 2
- O cliente pode ter os seguros básico ou parcial, dependendo da sua localidade.
* Se o cliente morar em São Paulo (SP), ele podera ter o seguro parcial.
* Se o cliente não atender a condições acima ele terá o seguro basico.

#### Categoria 3
- O cliente pode ter os seguros básico, parcial ou total, dependendo da sua localidade e idade, ou somente a idade.
* Se o cliente morar em São Paulo (SP) e tiver menos de 30 anos, ele poderá ter o seguro total.
* Se o cliente tiver menos de 30 anos, ele poderá ter o seguro parcial.
* Se o cliente não atender às condições do seguro total e parcial ele terá o seguro básico.


# Request (Requisição): 
Para auxiliar nos testes do sistema foi desenvolvido a documentação técnica desse sistema disponível através do Swagger:
- Basta digitar na URL do browser: http://localhost:1000/swagger-ui/index.html
- Foi disponibilizado às collections para realizar testes.
- O desenvolvimento das operações para pesquisar um ou todos os clientes, cadastrar, atualizar, deletar foi visando uma manutenção do sistema por algum administrador que precisará ter essa permissão. Para o cliente (Mobile ou Web) visando as regras de negócio acima, será disponibilizado a pesquisa de um cliente ou o cadastro de um novo cliente.

## Clientes
## Pesquisar todos os clientes
- GET http://localhost:1000/customers
* HEADERS:
** Accept=application/json
** Origin=http://localhost:8080


### Pesquisar um cliente
- GET http://localhost:1000/customers/1

- HTTP/1.1 200 OK 

### Cadastrar um cliente
- POST http://localhost:1000/customers
* BODY:
{
	"name": "João",
    "cpf": "123.456.789-10",
    "age": 29,
    "location": "BH",
    "value_vehicle": 70000
}

- HTTP/1.1 200 OK 

### Atualizar um cliente
- PUT http://localhost:1000/customers
* BODY:
{
	"id" : 1,
    "name": "João",
    "cpf": "123.456.789-10",
    "age": 29,
    "location": "SP",
    "value_vehicle": 80000
}

- HTTP/1.1 200 OK 

### Deletar um cliente
- DELETE http://localhost:1000/customers/1

- HTTP/1.1 204 NO CONTENT 

## Seguros

### Pesquisar todos os seguros
- GET http://localhost:1000/customers/1

- HTTP/1.1 200 OK 

## Pesquisar um seguro
- GET http://localhost:1000/insurances/3

- HTTP/1.1 200 OK 

## Cadastrar um seguro
- POST http://localhost:1000/insurances
* BODY:
{
    "type": "TOTAL",
    "cost": 5
}

- HTTP/1.1 200 OK 

## Atualizar um seguro
- PUT http://localhost:1000/insurances
* BODY:
{
    "id" : 4,
    "type": "TOTAL",
    "cost": 8
}

- HTTP/1.1 200 OK 

## Deletar um seguro
- DELETE http://localhost:1000/insurances/1

- HTTP/1.1 204 NO CONTENT
