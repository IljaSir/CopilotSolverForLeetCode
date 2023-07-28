class Solution:
    def countAndSay(self, n: int) -> str:
        
        if n == 1:
            return "1"
        prev = self.countAndSay(n-1)
        ans = ""
        i = 0
        while i < len(prev):
            c = prev[i]
            cnt = 1
            while i+1 < len(prev) and prev[i+1] == c:
                cnt += 1
                i += 1
            ans += str(cnt) + c
            i += 1
        return ans