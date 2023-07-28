class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        
        if len(word1) != len(word2):
            return False
        c1 = collections.Counter(word1)
        c2 = collections.Counter(word2)
        if set(c1.keys()) != set(c2.keys()):
            return False
        return sorted(c1.values()) == sorted(c2.values())