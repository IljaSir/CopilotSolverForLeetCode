class Solution:
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        
        def match(word):
            if len(word) != len(pattern):
                return False
            m = {}
            for i, c in enumerate(word):
                if c not in m:
                    m[c] = pattern[i]
                elif m[c] != pattern[i]:
                    return False
            return len(set(m.values())) == len(set(m.keys()))
        return [word for word in words if match(word)]