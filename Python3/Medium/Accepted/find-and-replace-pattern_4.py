class Solution:
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        
        def match(w):
            m = {}
            for i in range(len(w)):
                if w[i] in m:
                    if m[w[i]] != pattern[i]:
                        return False
                else:
                    m[w[i]] = pattern[i]
            return len(set(m.values())) == len(set(m.keys()))
        return [w for w in words if match(w)]