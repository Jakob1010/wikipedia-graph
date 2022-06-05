# wikipedia-graph
Hey! This application is intended to visualize wikipedia in the form of a graph.
The idea is to:
1. [TODO] Get the data. (wikipedia articles/pages and references)
2. [TODO] Store the data in a database. (neo4j)
3. [TODO] Built a REST API for accessing the data.
4. [TODO] Built a frontend application to visualize the data.
5. [TODO] Extend the application with some cool algorithms (e.g. shortest path).
6. [TODO] Maybe make a game out of it.

## generate sql dump and csv for import
1. First run **`fetch_sql_dump.sh`**  in order to download current wikipedia sql dump.
2. Extract dump.
3. Run **`page_sql_to_csv.py`** and redirect output to file e.g. 
```bash
python3 page_sql_to_csv.py > resources_tmp/pages.csv
```                          
