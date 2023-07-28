class Solution:
    def countAndSay(self, n: int) -> str:
        
        if n == 1:
            return '1'
        else:
            s = self.countAndSay(n-1)
            l = len(s)
            i = 0
            ans = ''
            while i < l:
                cnt = 1
                while i+1 < l and s[i] == s[i+1]:
                    cnt += 1
                    i += 1
                ans += str(cnt) + s[i]
                i += 1
            return ans