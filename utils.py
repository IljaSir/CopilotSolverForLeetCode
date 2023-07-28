import pathlib
import html
import re
import json

CLEANR = re.compile('<.*?>')

def read_from_file(file_name):
    with open(file_name, 'r') as file:
        return file.read()

def read_json_from_file(file_name):
    with open(file_name, 'r') as file:
        return json.load(file)

def write_to_file(file_name, content):
    with open(file_name, 'w') as file:
        file.write(content)

def append_to_file(file_name, content):
    with open(file_name, 'a') as file:
        file.write(content)

def get_current_path():
    return str(pathlib.Path().resolve()) + '/'

def change_html_sup(html):
    return html.replace('<sup>', '^')

def cleanhtml(raw_html):
  cleantext = re.sub(CLEANR, '', raw_html)
  return cleantext