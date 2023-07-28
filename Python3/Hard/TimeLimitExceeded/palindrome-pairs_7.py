class Solution:
    def palindromePairs(self, words: List[str]) -> List[List[int]]:
        
        # words = sorted(words, key=len)
        # print(words)
        # print('len(words):', len(words))
        res = []
        for i in range(len(words)):
            for j in range(len(words)):
                if i != j:
                    if (words[i] + words[j]) == (words[i] + words[j])[::-1]:
                        res.append([i, j])
        return res