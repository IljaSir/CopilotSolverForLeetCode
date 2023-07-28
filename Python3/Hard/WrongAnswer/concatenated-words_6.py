class Solution:
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
        
        def dfs(word, word_dict, memo):
            if word in memo:
                return memo[word]
            if word in word_dict:
                memo[word] = True
                return True
            for i in range(1, len(word)):
                prefix = word[:i]
                suffix = word[i:]
                if prefix in word_dict and dfs(suffix, word_dict, memo):
                    memo[word] = True
                    return True
            memo[word] = False
            return False
        word_dict = set(words)
        memo = {}
        result = []
        for word in words:
            if dfs(word, word_dict, memo):
                result.append(word)
        return result