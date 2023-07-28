class Solution:
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        
        ans = []
        for word in words:
            if self.match(word, pattern):
                ans.append(word)
        return ans