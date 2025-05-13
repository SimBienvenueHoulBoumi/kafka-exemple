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

NB : mon service kafka tourne dans un conteneur docker
