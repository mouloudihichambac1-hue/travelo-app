# Utilisation d'image Node.js allégée (Alpine)
FROM node:20-alpine AS build-stage

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build

# Utilisation d'image Nginx allégée
FROM nginx:alpine AS production-stage

# Sécurité : Mise à jour des paquets pour éviter les vulnérabilités
RUN apk update && apk upgrade --no-cache

# Suppression de la page d'accueil par défaut de Nginx
RUN rm -rf /usr/share/nginx/html/*

COPY --from=build-stage /app/build /usr/share/nginx/html

# Métadonnées pour la traçabilité
LABEL maintainer="Hicham MOULOUDI"
LABEL version="1.0"
LABEL description="Frontend React pour l'application Travelo"

# Exposition du port web standard
EXPOSE 80
# Lancement de Nginx
CMD ["nginx", "-g", "daemon off;"]