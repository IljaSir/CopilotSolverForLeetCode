class Solution:
    def countAndSay(self, n: int) -> str:
        
        if n == 1:
            return '1'
        else:
            s = self.countAndSay(n-1)
            count = 1
            res = ''
            for i in range(1, len(s)):
                if s[i] == s[i-1]:
                    count += 1
                else:
                    res += str(count) + s[i-1]
                    count = 1
            return res + str(count) + s[-1]