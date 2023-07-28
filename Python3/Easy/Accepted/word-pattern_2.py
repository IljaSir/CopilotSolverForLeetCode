class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        
        words = s.split(" ")
        if len(pattern) != len(words):
            return False
        p2w = {}
        w2p = {}
        for p, w in zip(pattern, words):
            if p in p2w:
                if p2w[p] != w:
                    return False
            else:
                p2w[p] = w
            if w in w2p:
                if w2p[w] != p:
                    return False
            else:
                w2p[w] = p
        return True