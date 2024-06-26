class Solution:
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
        
        words = set(words)
        def dfs(word):
            for i in range(1, len(word)):
                if word[:i] in words and (word[i:] in words or dfs(word[i:])):
                    return True
            return False
        return [word for word in words if dfs(word)]