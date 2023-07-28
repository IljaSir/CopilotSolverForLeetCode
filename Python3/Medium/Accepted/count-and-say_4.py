class Solution:
    def countAndSay(self, n: int) -> str:
        
        if n == 1:
            return '1'
        else:
            s = self.countAndSay(n-1)
            i = 0
            j = 0
            res = ''
            while i < len(s):
                while j < len(s) and s[j] == s[i]:
                    j += 1
                res += str(j-i) + s[i]
                i = j
            return res