import requests
from bs4 import BeautifulSoup

re = requests.get(url="https://www.chembk.com/cn/chem/108-95-2")

re.encoding("utf-8")

html = re.test

soup = BeautifulSoup(re.text, features="html.parser")

need = soup.find("meta",class_="detail_head")

dd = need.text.strip()

print(dd)