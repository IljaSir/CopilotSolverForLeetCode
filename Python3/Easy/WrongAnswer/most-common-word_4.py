class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        
        paragraph = paragraph.lower()
        paragraph = re.sub(r'[^\w\s]','',paragraph)
        paragraph = paragraph.split()
        for word in paragraph:
            if word in banned:
                paragraph.remove(word)
        return max(set(paragraph), key=paragraph.count)