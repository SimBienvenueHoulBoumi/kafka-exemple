🧪 Commandes utiles

## ▶️ Lancer chaque l'application
./mvnw spring-boot:run 

## 🔄 Rebuild complet du projet (clean + install des dépendances)
./mvnw clean install

## 🔁 Résoudre uniquement les dépendances, sans reconstruire le projet
./mvnw dependency:resolve

http://localhost:5002/swagger-ui/index.html#/producer-controller/

http://localhost:5003/swagger-ui/index.html#/consumer-controller/

⚙️ Procédure d'exécution

    Lancer Kafka via Docker (avec le nombre de brokers souhaité).

    Configurer le fichier application.yml pour qu’il pointe vers l'adresse correcte de ton broker Kafka.

    Démarrer le service producer et le service consumer, dans l’ordre que tu veux (Kafka gère la persistance des messages).

    Observer les échanges (via logs ou une interface type Kafka UI).

NB : mon service kafka tourne dans un conteneur docker de plus, je ne l'utilise pas ici mais voici l'arborescence ideale pour des microservices

```bash
src/main/java/com/monapp/serviceorder/
├── adapter/
│   ├── controller/              # HTTP & REST adapters (@RestController)
│   ├── event/                   # Kafka consumers (@KafkaListener)
│   └── publisher/               # Kafka producers
│
├── application/                
│   ├── port/in/                 # UseCases exposés (interfaces)
│   │   └── CreateOrderUseCase.java
│   └── port/out/                # Interfaces vers l’extérieur
│       └── OrderEventPublisherPort.java
│
├── domain/
│   ├── model/                   # Entités métier pures (DDD)
│   │   └── Order.java
│   └── service/                 # Règles métier (OrderValidator, etc.)
│
├── infrastructure/
│   ├── persistence/             # impl. repository (JPA, Mongo, etc.)
│   ├── messaging/               # impl. event publisher/consumer
│   └── config/                  # Spring/Kafka config
│
└── serviceorderApplication.java

```
