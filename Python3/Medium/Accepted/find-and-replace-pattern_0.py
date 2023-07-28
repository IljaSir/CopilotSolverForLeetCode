class Solution:
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        
        def match(word):
            p = {}
            for x, y in zip(word, pattern):
                if x not in p:
                    p[x] = y
                elif p[x] != y:
                    return False
            return len(set(p.values())) == len(p.values())
        return [word for word in words if match(word)]