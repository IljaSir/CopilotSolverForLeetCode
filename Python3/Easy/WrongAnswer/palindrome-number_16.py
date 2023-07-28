class Solution:
    def isPalindrome(self, x: int) -> bool:
        
        if x < 0:
            return False
        if x < 10:
            return True
        if x % 10 == 0:
            return False
        if x < 100:
            return x % 11 == 0
        if x < 1000:
            return x % 111 == 0
        if x < 10000:
            return x % 1111 == 0
        if x < 100000:
            return x % 11111 == 0
        if x < 1000000:
            return x % 111111 == 0
        if x < 10000000:
            return x % 1111111 == 0
        if x < 100000000:
            return x % 11111111 == 0
        if x < 1000000000:
            return x % 111111111 == 0
        if x < 10000000000:
            return x % 1111111111 == 0
        if x < 100000000000:
            return x % 11111111111 == 0
        if x < 1000000000000:
            return x % 111111111111 == 0
        if x < 10000000000000:
            return x % 1111111111111 == 0
        if x < 100000000000000:
            return x % 11111111111111 == 0
        if x < 1000000000000000:
            return x % 111111111111111 == 0
        if x < 10000000000000000:
            return x % 1111111111111111 == 0
        if x < 100000000000000000:
            return x % 11111111111111111 == 0
        if x < 1000000000000000000:
            return x % 111111111111111111 == 0
        if x < 10000000000000000000:
            return x % 1111111111111111111 == 0
        if x < 100000000000000000000:
            return x % 11111111111111111111 == 0
        if x < 1000000000000000000000:
            return x % 111