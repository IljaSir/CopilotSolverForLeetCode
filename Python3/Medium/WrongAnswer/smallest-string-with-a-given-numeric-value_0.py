class Solution:
    def getSmallestString(self, n: int, k: int) -> str:
        
        res = ""
        for i in range(n):
            res += chr(ord('a') + min(k - (n - i - 1) * 26, 26) - 1)
            k -= min(k - (n - i - 1) * 26, 26)
        return res