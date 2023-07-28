class Solution:
    def largestMerge(self, word1: str, word2: str) -> str:
        
        # print(word1, word2)
        if word1 == word2:
            return word1
        if not word1 or not word2:
            return word1 or word2
        if word1[0] > word2[0]:
            return word1[0] + self.largestMerge(word1[1:], word2)
        elif word1[0] < word2[0]:
            return word2[0] + self.largestMerge(word1, word2[1:])
        else:
            return word1[0] + self.largestMerge(word1[1:], word2[1:])
        # return word1[0] + self.largestMerge(word1[1:], word2) if word1[0] > word2[0] else word2[0] + self.largestMerge(word1, word2[1:])