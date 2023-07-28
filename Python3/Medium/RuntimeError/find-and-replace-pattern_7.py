class Solution:
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        
        pattern = self.get_pattern(pattern)
        res = []
        for word in words:
            if pattern == self.get_pattern(word):
                res.append(word)
        return res