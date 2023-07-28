class Solution:
    def isPalindrome(self, x: int) -> bool:
        
        if x<0:
            return False
        if x<10:
            return True
        if x%10==0:
            return False
        reverse = 0
        while x>reverse:
            reverse = reverse*10 + x%10
            x = x//10
        if x==reverse or x==reverse//10:
            return True
        return False