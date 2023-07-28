class Solution:
    def findArray(self, pref: List[int]) -> List[int]:
        
        n = len(pref)
        res = [0] * n
        for i in range(1, n):
            res[i] = res[i - 1] ^ pref[i - 1]
        res[n - 1] = res[n - 1] ^ pref[n - 1]
        return res