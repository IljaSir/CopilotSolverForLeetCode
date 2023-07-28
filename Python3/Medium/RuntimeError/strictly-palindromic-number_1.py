class Solution:
    def isStrictlyPalindromic(self, n: int) -> bool:
        
        for base in range(2, n - 1):
            num = self.convert_to_base(n, base)
            if not self.is_palindromic(num):
                return False
        return True