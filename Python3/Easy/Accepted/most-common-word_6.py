class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        
        import re
        from collections import Counter
        paragraph = re.sub('[^a-zA-Z]+', ' ', paragraph)
        paragraph = paragraph.lower()
        paragraph = paragraph.split()
        paragraph = [word for word in paragraph if word not in banned]
        return Counter(paragraph).most_common(1)[0][0]