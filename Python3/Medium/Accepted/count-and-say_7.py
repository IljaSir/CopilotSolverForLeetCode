class Solution:
    def countAndSay(self, n: int) -> str:
        
        if n == 1:
            return "1"
        else:
            s = self.countAndSay(n-1)
            ss = ""
            i = 0
            while i < len(s):
                j = i
                while j < len(s) and s[j] == s[i]:
                    j += 1
                ss += str(j-i) + s[i]
                i = j
            return ss