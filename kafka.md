Для подключения к конкретному контейнеру:
`docker-compose exec kafka3 /bin/bash`

Создание топиков:
`kafka-topics.sh --bootstrap-server localhost:9092 --create --topic payments --replication-factor 3 --partitions 1`

Просмотр списка топиков:
`kafka-topics.sh --bootstrap-server localhost:9092 --list`

Запуск producer'а:
`kafka-console-producer.sh --bootstrap-server localhost:9092 --topic payments`

Запуск consumera'а:
`kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic payments --group logger --from-beginning`

Просмотр __consumer_offsets:
* самое новое: `kafka-run-class.sh kafka.tools.GetOffsetShell --broker-list localhost:9092 --topic payments --time -1`
* самое старое: `kafka-run-class.sh kafka.tools.GetOffsetShell --broker-list localhost:9092 --topic payments --time -2`
