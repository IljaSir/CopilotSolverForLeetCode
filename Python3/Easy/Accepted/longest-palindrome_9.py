class Solution:
    def longestPalindrome(self, s: str) -> int:
        
        # Solution 1: 32 ms (68.07%)
        # count = 0
        # odd = 0
        # for i in set(s):
        #     count += s.count(i)//2*2
        #     if s.count(i)%2 == 1:
        #         odd = 1
        # return count+odd
        # Solution 2: 24 ms (95.37%)
        count = 0
        for i in set(s):
            count += s.count(i)//2*2
        return count+1 if count<len(s) else count