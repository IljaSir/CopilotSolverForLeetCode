class Solution:
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        
        def match(word):
            m1 = {}
            m2 = {}
            for w, p in zip(word, pattern):
                if w not in m1:
                    m1[w] = p
                if p not in m2:
                    m2[p] = w
                if m1[w] != p or m2[p] != w:
                    return False
            return True
        return [w for w in words if match(w)]