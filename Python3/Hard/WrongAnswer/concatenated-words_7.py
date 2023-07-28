class Solution:
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
        
        words = sorted(words, key = len)
        ans = []
        for i in range(2, len(words)):
            for j in range(i):
                if words[j] in words[i]:
                    ans.append(words[i])
                    break
        return ans