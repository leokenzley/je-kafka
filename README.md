## Estudando kafka

### Infraestrutura
#### Instalando o kafka com docker
- [X] Zookeeper
- [X] Kafka
- [X] Kafdrop

```shell
  cd docker && \
  docker compose up -d
```
#### Para acessar a interface do Kafdrop
- Acesse o navegador e entre em `http://localhost:9000`

### Publicando mensagem
```shell
    curl --location 'http://localhost:8081/producer' \
    --header 'Content-Type: application/json' \
    --data '{
        "message": "Test send message 1"
    }'
```