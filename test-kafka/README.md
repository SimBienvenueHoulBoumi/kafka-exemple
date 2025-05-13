
---

## 🏗️ Étape 1 — Créer le projet `shared-lib`

Tu peux appeler ça `shared-lib`, `common-utils`, ou `monapp-shared` — à toi l’inspiration.

```bash
mkdir shared-lib
cd shared-lib

mvn archetype:generate \
  -DgroupId=com.monapp.shared \
  -DartifactId=shared-lib \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DinteractiveMode=false
```

🎁 Cela te génère une lib Java de base.

---

## 🧬 Étape 2 — Préparer le `pom.xml`

On modifie le `pom.xml` pour dire : "Je suis une lib à publier sur Nexus".

### `pom.xml` minimal :

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.monapp.shared</groupId>
    <artifactId>shared-lib</artifactId>
    <version>1.0.0</version>
    <packaging>jar</packaging>

    <name>shared-lib</name>

    <distributionManagement>
        <repository>
            <id>nexus-local</id>
            <url>http://127.0.0.1:8081/repository/maven-releases/</url>
        </repository>
        <snapshotRepository>
            <id>nexus-local</id>
            <url>http://127.0.0.1:8081/repository/maven-snapshots/</url>
        </snapshotRepository>
    </distributionManagement>
</project>
```

---

## 🔐 Étape 3 — Ajouter les credentials dans `~/.m2/settings.xml`

Crée (ou modifie) le fichier `~/.m2/settings.xml` :

```xml
<settings>
  <servers>
    <server>
      <id>nexus-local</id>
      <username>admin</username>
      <password>TON_MOT_DE_PASSE</password>
    </server>
  </servers>
</settings>
```

🧠 Tu peux choper le mot de passe d’origine de Nexus ici :

```
/nexus-data/admin.password
```

---

## 🚀 Étape 4 — Publier dans Nexus

Compile et installe :

```bash
mvn clean install
```

Puis déploie :

```bash
mvn deploy
```

Si tout est bon, tu verras le JAR apparaître dans ton Nexus sur cette URL :

```
http://127.0.0.1:8081/#browse/browse:maven-releases
```

---

## 🧩 Étape 5 — Utiliser la shared-lib dans un microservice

Dans le `pom.xml` de ton microservice :

```xml
<dependencies>
  <dependency>
    <groupId>com.monapp.shared</groupId>
    <artifactId>shared-lib</artifactId>
    <version>1.0.0</version>
  </dependency>
</dependencies>

<repositories>
  <repository>
    <id>nexus-local</id>
    <url>http://127.0.0.1:8081/repository/maven-releases/</url>
  </repository>
</repositories>
```
## ajoute cette configuration dans ~/.m2/settings.xml

```xml
<settings>
  <servers>
    <server>
      <id>nexus-local</id>
      <username>admin</username>
      <password>21d8186c-ccc7-4449-8875-f18a11af08be</password>
    </server>
  </servers>
</settings>
```



---


# copy nexus pass
docker exec -it nexus bash
cat /nexus-data/admin.password
