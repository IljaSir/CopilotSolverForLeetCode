class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        
        paragraph = paragraph.lower()
        paragraph = paragraph.replace('!',' ')
        paragraph = paragraph.replace(',',' ')
        paragraph = paragraph.replace('.',' ')
        paragraph = paragraph.replace('?',' ')
        paragraph = paragraph.replace(';',' ')
        paragraph = paragraph.replace("'",' ')
        paragraph = paragraph.split(' ')
        paragraph = list(filter(lambda x: x != '', paragraph))
        paragraph = list(filter(lambda x: x not in banned, paragraph))
        paragraph = dict(Counter(paragraph))
        return max(paragraph, key=paragraph.get)