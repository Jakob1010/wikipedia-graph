"""
Convert all insert statements from 'dewiki-20220320-pagelinks.sql' to csv schema.
The pagelink sql references from page_id to title. Therefore, we first have to replace
all tilte attributes with the correct page_id. 
"""


# 1. Create {page_title -> id} hashmap
PAGES_FILENAME = "pages.csv"
PAGES_PATH = "resources_tmp/import/"
PAGES_FILE = open(PAGES_PATH + PAGES_FILENAME)

title_to_id = {}
for line in PAGES_FILE:
    page_attributes = line.split(',')
    title_to_id[page_attributes[2]] = page_attributes[0]

# 2. Extract pagelinks and print to stout
PAGELINKS_FILENAME = "dewiki-20220320-pagelinks.sql"
PAGELINKS_PATH = "resources_tmp/"
PAGELINKS_FILE = open(PAGELINKS_PATH + PAGELINKS_FILENAME)

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
                page_record_found = True
            # end of object
            elif character == ')' and line[j+1] == ',':
                n = len(out.split(','))
                if n == PAGE_RECORD_ATTRIBUTES:
                    print(out)
                page_record_found = False
                out = ""
            elif page_record_found:
                out += character

