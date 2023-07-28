class Solution:
    def isPrefixString(self, s: str, words: List[str]) -> bool:
        
        i = 0
        for word in words:
            if s.startswith(word, i):
                i += len(word)
            else:
                return False
        return len(s) == i