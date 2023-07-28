class Solution:
    def largestPalindromic(self, num: str) -> str:
        
        num = sorted(num, reverse=True)
        return ''.join(num)