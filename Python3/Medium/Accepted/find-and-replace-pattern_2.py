class Solution:
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        
        def match(word):
            d = {}
            for c1, c2 in zip(word, pattern):
                if c1 in d:
                    if d[c1] != c2:
                        return False
                else:
                    d[c1] = c2
            return len(set(d.values())) == len(d.values())
        return [word for word in words if match(word)]