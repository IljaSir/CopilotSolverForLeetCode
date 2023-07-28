class Solution:
    def countAnagrams(self, s: str) -> int:
        
        # print(s)
        s = s.split(' ')
        # print(s)
        s.sort()
        # print(s)
        s = ''.join(s)
        # print(s)
        res = 1
        for i in range(1, len(s)):
            if s[i] == s[i-1]:
                res += 1
            else:
                res *= 2
        return res % (10**9 + 7)