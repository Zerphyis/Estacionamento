# Projeto de Gerenciamento de Estacionamento

Este projeto é um sistema de gerenciamento de estacionamento que permite controlar a entrada e saída de veículos, além de gerenciar vagas de carros e motos. O sistema foi desenvolvido em Java com o uso do Spring Boot e segue uma arquitetura baseada em entidades, repositórios, serviços e controladores.

## Repositório Original
Este projeto foi baseado em um desafio disponível no repositório do GitHub:
- **Repositório Original**: [Link para o repositório original](https://github.com/fcamarasantos/backend-test-java)  

## Principais Funcionalidades

**Gerenciamento de Estacionamentos**:
   - Cadastro de estacionamentos com informações como nome, CNPJ, endereço, telefone, número de vagas para carros e motos.
   - Atualização e exclusão de estacionamentos.
   - Listagem de todos os estacionamentos cadastrados.

**Gerenciamento de Veículos**:
   - Registro de veículos com informações como marca, modelo, cor, placa e tipo (carro ou moto).
   - Verificação de placa duplicada.
   - Atualização e exclusão de veículos.
   - Busca de veículos por placa.

 **Controle de Entrada e Saída de Veículos**:
   - Registro de entrada de veículos com informações como nome do condutor, placa do veículo, tipo de veículo e ID do estacionamento.
   - Registro de saída de veículos, atualizando automaticamente o número de vagas disponíveis.
   - Validação de vagas disponíveis no estacionamento.

 **API REST**:
   - Endpoints para gerenciar estacionamentos, veículos e registrar entrada/saída de veículos.
   - Respostas HTTP adequadas para sucesso e erros.

## Estrutura do Projeto

### Entidades (Entities)
- **Parking**: Representa um estacionamento.
- **Vehicle**: Representa um veículo.
- **EntryExit**: Representa o registro de entrada e saída de um veículo.
- **TypeVehicle**: Enum que define os tipos de veículos (CARRO ou MOTOCICLETA).

### Repositórios (Repositories)
- **ParkingRepository**: Interface para operações CRUD relacionadas a estacionamentos.
- **VehicleRepository**: Interface para operações CRUD relacionadas a veículos, incluindo busca por placa.
- **EntryExitRepository**: Interface para operações CRUD relacionadas a entradas e saídas de veículos.

### Serviços (Services)
- **ParkingService**: Lógica de negócio para gerenciamento de estacionamentos.
- **VehicleService**: Lógica de negócio para gerenciamento de veículos.
- **EntryExitService**: Lógica de negócio para controle de entrada e saída de veículos.

### Controladores (Controllers)
- **ParkingController**: Expõe endpoints para gerenciar estacionamentos.
- **VehicleController**: Expõe endpoints para gerenciar veículos.
- **EntryExitController**: Expõe endpoints para registrar entrada e saída de veículos.

### DTOs (Data Transfer Objects)
- **DataParking**: DTO para receber dados de cadastro/atualização de estacionamentos.
- **DataVehicle**: DTO para receber dados de cadastro/atualização de veículos.

## Tecnologias Utilizadas
- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **Spring Data JPA**: Para acesso a dados e operações de banco de dados.
- **Hibernate**: ORM para mapeamento objeto-relacional.
- **Validação de Dados**: Uso de anotações como `@NotBlank` e `@NotNull` para validação de campos.
- **API REST**: Utilização de `@RestController` e `@RequestMapping` para expor endpoints.
- **Banco de Dados**: MySQL para armazenamento de dados.

## Banco de Dados
O projeto utiliza o **MySQL** como banco de dados relacional. As tabelas são criadas automaticamente pelo Hibernate com base nas entidades definidas no código. Certifique-se de configurar as propriedades do banco de dados no arquivo `application.properties`:

## Exemplos de Endpoints

### Estacionamentos
- **POST /estacionamentos**: Cadastra um novo estacionamento.
<br>

![Image](https://github.com/user-attachments/assets/8168d8e5-334b-486e-9936-35a5fc727983)
<br>
- **GET /estacionamentos**: Lista todos os estacionamentos.
 <br>
 
![Image](https://github.com/user-attachments/assets/4c698db6-b32f-4c9c-8a85-4086e47470bb)
<br>
- **GET /estacionamentos/{id}**: Busca um estacionamento por ID.
<br>
 
![Image](https://github.com/user-attachments/assets/4c698db6-b32f-4c9c-8a85-4086e47470bb)
<br>
- **PUT /estacionamentos/{id}**: Atualiza um estacionamento existente.
 <br>
 
![Image](https://github.com/user-attachments/assets/e17dfda3-2a18-4b0f-a8b8-305d57f9f84b)
<br>
- **DELETE /estacionamentos/{id}**: Exclui um estacionamento.

 <br>
 
 ![Image](https://github.com/user-attachments/assets/8a51c01e-6ed2-40dc-a33c-8bf8255918d7)
<br>

### Veículos
- **POST /veiculos**: Cadastra um novo veículo.
<br>

![Image](https://github.com/user-attachments/assets/da98a226-da66-4bf2-9096-a87ce113dcb8)
  <br>
- **GET /veiculos**: Lista todos os veículos.
 <br>

![Image](https://github.com/user-attachments/assets/41d4f6ae-d57c-4225-8fcf-4e3ad1264c3c)
 <br>  
- **GET /veiculos/{placa}**: Busca um veículo por placa.
 <br>

![Image](https://github.com/user-attachments/assets/7f63771b-d3a0-4205-808a-cad652b62df7)
 <br>  
- **PUT /veiculos/{id}**: Atualiza um veículo existente.
 <br>
 
![Image](https://github.com/user-attachments/assets/3eb95d5f-2a81-41c6-a47c-c656e471e6c0)
 <br>  
- **DELETE /veiculos/{id}**: Exclui um veículo.
<br>

![Image](https://github.com/user-attachments/assets/18089707-09a7-4bdf-ab6d-5ae871c3d16b)
<br>

### Entrada/Saída de Veículos
- **POST /registro/entrada**: Registra a entrada de um veículo.
  <br>

![Image](https://github.com/user-attachments/assets/d453a751-8d6e-41bc-bff2-7388d3268f92)
  <br>
- **POST /registro/saida/{id}**: Registra a saída de um veículo.
 <br>
 
![Image](https://github.com/user-attachments/assets/d5282fc5-745e-4b06-948d-a7b3519197a7)
  <br>

## Como Executar
1. Clone o repositório do projeto.
2. Configure o banco de dados no arquivo `application.properties`.
3. Execute a aplicação Spring Boot.
4. Acesse os endpoints via Postman, Insomnia ou qualquer cliente HTTP.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
