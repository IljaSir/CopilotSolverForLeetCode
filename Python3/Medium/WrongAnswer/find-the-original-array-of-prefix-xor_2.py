class Solution:
    def findArray(self, pref: List[int]) -> List[int]:
        
        n = len(pref)
        arr = [0] * n
        for i in range(1, n):
            arr[i] = arr[i-1] ^ pref[i-1]
        arr[0] = pref[0]
        return arr