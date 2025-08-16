## Estudando kafka

### Infraestrutura
#### Instalando o kafka com docker
- [X] Zookeeper
- [X] Kafka
- [X] Kafdrop
- [X] Java 24
- [X] Springboot 3.5.4

```shell
  cd docker && \
  docker compose up -d
```
#### Para acessar a interface do Kafdrop
- Acesse o navegador e entre em `http://localhost:9000`

### Execute os projetos
```shell
  cd docker && \
  docker compose up -d
```

### Publicando mensagem
```shell
    curl --location 'http://localhost:8081/producer' \
    --header 'Content-Type: application/json' \
    --data '{
        "message": "Test send message 1"
    }'
```