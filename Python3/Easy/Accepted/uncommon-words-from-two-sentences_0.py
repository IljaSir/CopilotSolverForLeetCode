class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> List[str]:
        
        d = {}
        for word in s1.split():
            d[word] = d.get(word, 0) + 1
        for word in s2.split():
            d[word] = d.get(word, 0) + 1
        return [word for word, count in d.items() if count == 1]