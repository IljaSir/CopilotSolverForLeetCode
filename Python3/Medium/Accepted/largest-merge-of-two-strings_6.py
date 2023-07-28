class Solution:
    def largestMerge(self, word1: str, word2: str) -> str:
        
        n1, n2 = len(word1), len(word2)
        i, j = 0, 0
        res = []
        while i < n1 or j < n2:
            if word1[i:] > word2[j:]:
                res.append(word1[i])
                i += 1
            else:
                res.append(word2[j])
                j += 1
        return ''.join(res)