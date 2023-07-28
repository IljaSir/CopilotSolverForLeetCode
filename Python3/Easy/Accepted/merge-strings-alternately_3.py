class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        
        word1 = list(word1)
        word2 = list(word2)
        merge = []
        while word1 or word2:
            if word1:
                merge.append(word1.pop(0))
            if word2:
                merge.append(word2.pop(0))
        return ''.join(merge)