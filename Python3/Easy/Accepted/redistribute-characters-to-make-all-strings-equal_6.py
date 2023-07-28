class Solution:
    def makeEqual(self, words: List[str]) -> bool:
        
        from collections import Counter
        c = Counter()
        for word in words:
            c += Counter(word)
        for key in c:
            if c[key] % len(words) != 0:
                return False
        return True