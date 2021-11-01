# Viasão Geral

Uma aplicação demonstrando de forma simples, como utilizar o serviço de mensageria da AWS, SQS, através do JMS, clusterizando de forma local através do **Localstack**.

Aprecie sem moderação 🤟😄 e evolua..

## Passos para o Localstack

<h3>Localstack docker-compose:</h3>

```
version: '2.1'
services:
  localstack:
    image: localstack/localstack
    ports:
      - "4576:4576"
    environment:
      - SERVICES=sqs
```

<h3>Instale e configure o AWS CLI na sua máquina:</h3>

- [AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-install.html) AWS Command Line Interface

<h3>Aplique suas configurações padrões:</h3>

```
aws configure --profile default
```

<hr/>

**PS.:** Por favor, informe **us-east-2** como sua região padrão, ou altere o **application.properties** da aplicação.

<hr/>

</br>

<h3>Crie a fila necessária para a aplicação:</h3>

```
aws --endpoint-url=http://localhost:4576 sqs create-queue --queue-name sqs-queue-example
```

<h3>Teste o envio de mensagens:</h3>

```
aws --endpoint-url=http://localhost:4576 sqs send-message --queue-url http://localhost:4576/000000000000/sqs-queue-example --message-body "Mensagem de teste"
```

<h3>Teste o consumo de mensagens:</h3>

```
aws --endpoint-url=http://localhost:4576 sqs receive-message --queue-url http://localhost:4576/queue/sqs-queue-example --max-number-of-messages 10
```

Isso é tudo. Be happy! 😊
