class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        
        rec = [0] * len(arr)
        for i in range(len(arr)):
            rec[i] = max(rec[i-1], arr[i])
        res = 0
        tmp = 0
        for i in range(len(arr)):
            tmp = max(tmp, arr[i])
            if tmp == rec[i]:
                res += 1
        return res