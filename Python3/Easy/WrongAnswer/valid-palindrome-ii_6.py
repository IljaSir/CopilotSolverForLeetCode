class Solution:
    def validPalindrome(self, s: str) -> bool:
        
        if len(s) == 1:
            return True
        if len(s) == 2:
            return s[0] == s[1]
        if s[0] == s[-1]:
            return self.validPalindrome(s[1:-1])
        else:
            return self.validPalindrome(s[1:]) or self.validPalindrome(s[:-1])