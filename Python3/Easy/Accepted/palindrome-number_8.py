class Solution:
    def isPalindrome(self, x: int) -> bool:
        
        if x < 0:
            return False
        x_list = [int(d) for d in str(x)]
        return x_list == x_list[::-1]