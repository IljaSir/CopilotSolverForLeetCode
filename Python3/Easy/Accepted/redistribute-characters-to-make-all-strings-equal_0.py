class Solution:
    def makeEqual(self, words: List[str]) -> bool:
        
        d = {}
        for word in words:
            for c in word:
                d[c] = d.get(c, 0) + 1
        return all(v % len(words) == 0 for v in d.values())