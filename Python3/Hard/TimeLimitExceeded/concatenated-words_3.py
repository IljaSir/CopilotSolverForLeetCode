class Solution:
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
        
        def dfs(word, i, count):
            if i == len(word):
                return count > 1
            for j in range(i, len(word)):
                if word[i:j+1] in word_set:
                    if dfs(word, j+1, count+1):
                        return True
            return False

        word_set = set(words)
        res = []
        for word in words:
            if dfs(word, 0, 0):
                res.append(word)
        return res