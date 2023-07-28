class Solution:
    def countAndSay(self, n: int) -> str:
        
        if n == 1:
            return "1"
        res = "1"
        for i in range(2, n + 1):
            tmp = ""
            cnt = 1
            for j in range(1, len(res)):
                if res[j - 1] == res[j]:
                    cnt += 1
                else:
                    tmp += str(cnt) + res[j - 1]
                    cnt = 1
            tmp += str(cnt) + res[-1]
            res = tmp
        return res