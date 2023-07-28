class Solution:
    def minFlips(self, s: str) -> int:
        
        # s = s + s[:2]
        # n = len(s)
        # res = n
        # for i in range(n-2):
        #     tmp = 0
        #     for j in range(i, i + 3):
        #         if s[j] == s[j+1]:
        #             tmp += 1
        #     res = min(res, tmp)
        # return res
        
        s = s + s[:2]
        n = len(s)
        res = n
        for i in range(n-2):
            tmp = 0
            for j in range(i, i + 3):
                if s[j] == s[j+1]:
                    tmp += 1
            res = min(res, tmp)
        return res