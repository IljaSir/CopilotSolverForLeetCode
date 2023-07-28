class Solution:
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        
        def match(word):
            d = {}
            for a, b in zip(pattern, word):
                if a in d:
                    if d[a] != b:
                        return False
                else:
                    d[a] = b
            return len(set(d.values())) == len(d.values())
        return list(filter(match, words))