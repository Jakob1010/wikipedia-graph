FROM neo4j:latest

COPY import/* /var/lib/neo4j/import/

COPY import.sh import.sh

ENV EXTENSION_SCRIPT=import.sh

CMD [ "neo4j" ]
