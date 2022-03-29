"""
Convert all insert statements from 'dewiki-20220320-page.sql' to csv schema.
"""


FILE_NAME = "dewiki-20220320-page"
PATH = "resources_tmp/"
INPUT_FILE = open(PATH + FILE_NAME + '.sql')
OUTPUT_FILE = open(PATH + FILE_NAME + '.csv','w')

insert_found = False
for i, line in enumerate(INPUT_FILE):
    if line.startswith('INSERT INTO'):
        insert_found = True
        # TODO: find way to split records



