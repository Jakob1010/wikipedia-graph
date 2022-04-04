"""
Convert all insert statements from 'dewiki-20220320-page.sql' to csv schema.
"""


FILE_NAME = "dewiki-20220320-page"
PATH = "resources_tmp/"
INPUT_FILE = open(PATH + FILE_NAME + '.sql')
PAGE_RECORD_ATTRIBUTES = 13

out = ""
insert_statement_found = False
page_record_found = False

for i, line in enumerate(INPUT_FILE):

    # start from first insert statement
    if line.startswith('INSERT INTO'):
        insert_statement_found = True

    if insert_statement_found:
        # iterate over single line
        for j, character in enumerate(line):
            # start of object
            if character == '(':
                insert_statement_found = True
            # end of object
            elif character == ')' and line[j+1] == ',':

                n = len(out.split(','))
                if n == PAGE_RECORD_ATTRIBUTES:
                    print(out)

                insert_statement_found = False
                out = ""
            elif insert_statement_found:
                out += character
