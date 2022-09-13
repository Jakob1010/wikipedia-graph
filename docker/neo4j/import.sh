#!/bin/sh
if [ ! -d /data/databases/neo4j.db ]; then { /var/lib/neo4j/bin/neo4j-admin import \
--database=neo4j \
--skip-bad-relationships  \
--nodes=Page="/var/lib/neo4j/import/pages_header.csv,/var/lib/neo4j/import/pages.csv" \
--relationships=Pagelink="/var/lib/neo4j/import/pagelinks_header.csv,/var/lib/neo4j/import/pagelinks.csv" \
; chmod -R 777 /data; chmod -R 777 /logs; } else { echo "data was already imported!"; } fi
