class Solution:
    def isPalindrome(self, x: int) -> bool:
        
        if x < 0:
            return False
        if x < 10:
            return True
        digits = []
        while x > 0:
            digits.append(x % 10)
            x //= 10
        for i in range(len(digits) // 2):
            if digits[i] != digits[-i - 1]:
                return False
        return True