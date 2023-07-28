class Solution:
    def validPalindrome(self, s: str) -> bool:
        
        def isPalindrome(s, i, j):
            while i < j:
                if s[i] != s[j]:
                    return False
                i += 1
                j -= 1
            return True

        i = 0
        j = len(s) - 1
        while i < j:
            if s[i] != s[j]:
                return isPalindrome(s, i + 1, j) or isPalindrome(s, i, j - 1)
            i += 1
            j -= 1
        return True