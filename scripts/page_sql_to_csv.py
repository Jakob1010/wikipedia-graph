"""
Convert all insert statements from 'dewiki-20220320-page.sql' to csv schema.
"""


FILE_NAME = "dewiki-20220320-page"
PATH = "resources_tmp/"
INPUT_FILE = open(PATH + FILE_NAME + '.sql')

out = ""
insert_statement_found = False
page_object_found = False

for i, line in enumerate(INPUT_FILE):

    # start from first insert statement
    if line.startswith('INSERT INTO'):
        insert_statement_found = True

    if insert_statement_found:
        # iterate over single line
        for j, character in enumerate(line):
            if character == '(':
                page_object_found = True
            elif character == ')' and line[j+1] == ',':
                # ignore semicolon in between two objects
                print(out)
                page_object_found = False
                out = ""
            elif page_object_found:
                out += character




