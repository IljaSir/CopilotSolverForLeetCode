class Solution:
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        
        res = []
        for word in words:
            if len(word) != len(pattern):
                continue
            d1 = {}
            d2 = {}
            flag = True
            for i in range(len(pattern)):
                if pattern[i] not in d1:
                    d1[pattern[i]] = word[i]
                if word[i] not in d2:
                    d2[word[i]] = pattern[i]
                if d1[pattern[i]] != word[i] or d2[word[i]] != pattern[i]:
                    flag = False
                    break
            if flag:
                res.append(word)
        return res