class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        
        paragraph = paragraph.replace(',', ' ').replace('.', ' ').replace('!', ' ').replace('?', ' ').replace(';', ' ').replace("'", ' ')
        paragraph = paragraph.lower()
        paragraph = paragraph.split()
        d = {}
        for word in paragraph:
            if word not in banned:
                if word in d:
                    d[word] += 1
                else:
                    d[word] = 1
        return max(d, key=d.get)