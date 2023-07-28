class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        
        if len(word1) != len(word2):
            return False
        if set(word1) != set(word2):
            return False
        counter1 = collections.Counter(word1)
        counter2 = collections.Counter(word2)
        return sorted(counter1.values()) == sorted(counter2.values())