class Solution:
    def isPrefixString(self, s: str, words: List[str]) -> bool:
        
        word = ''
        for i in words:
            word += i
            if word == s:
                return True
        return False