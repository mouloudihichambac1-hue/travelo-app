# --- Étape 1 : Construction (Build stage) ---
FROM maven:3.9-eclipse-temurin-21-alpine AS builder
WORKDIR /app

# Optimisation du cache : téléchargement des dépendances
COPY pom.xml .
RUN mvn dependency:go-offline

# Copie du code source et compilation (sans lancer les tests liés à la BDD)
COPY src ./src
RUN mvn clean package -DskipTests

# --- Étape 2 : Exécution (Run stage) ---
# Utilisation de l'image optimisée (0 vulnérabilité critique/haute)
FROM eclipse-temurin:21-jre-alpine-3.24
WORKDIR /app

#  pour éviter les vulnérabilités : Mise à jour des paquets de l'OS
RUN apk update && apk upgrade --no-cache

# pratique de sécurité : création d'un utilisateur non-root
RUN addgroup -S travelogroup && adduser -S travelouser -G travelogroup
USER travelouser:travelogroup


COPY --from=builder /app/target/*.jar app.jar


EXPOSE 8080


ENTRYPOINT ["java", "-jar", "app.jar"]