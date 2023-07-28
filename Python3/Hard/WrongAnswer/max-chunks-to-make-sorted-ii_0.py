class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        
        n = len(arr)
        mx = 0
        res = 0
        for i in range(n):
            mx = max(mx, arr[i])
            if mx == i:
                res += 1
        return res