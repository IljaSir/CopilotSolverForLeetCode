class Solution:
    def countAndSay(self, n: int) -> str:
        
        if n == 1:
            return "1"
        pre = self.countAndSay(n-1)
        res = ""
        count = 1
        for i in range(1, len(pre)):
            if pre[i] == pre[i-1]:
                count += 1
            else:
                res += str(count) + pre[i-1]
                count = 1
        res += str(count) + pre[-1]
        return res