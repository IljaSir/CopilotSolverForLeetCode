class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        
        # print(word1, word2)
        if len(word1) == 0:
            return word2
        if len(word2) == 0:
            return word1
        if word1[0] > word2[0]:
            return word2[0] + self.mergeAlternately(word1, word2[1:])
        else:
            return word1[0] + self.mergeAlternately(word1[1:], word2)