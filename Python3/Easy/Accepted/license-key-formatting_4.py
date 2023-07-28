class Solution:
    def licenseKeyFormatting(self, s: str, k: int) -> str:
        
        s = s.replace("-", "").upper()
        res = ""
        for i in range(len(s)-1, -1, -1):
            if len(res)%(k+1) == k:
                res = "-" + res
            res = s[i] + res
        return res