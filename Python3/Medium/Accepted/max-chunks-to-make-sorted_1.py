class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        
        maxs = [0] * len(arr)
        mins = [0] * len(arr)
        maxs[0] = arr[0]
        mins[-1] = arr[-1]
        for i in range(1, len(arr)):
            maxs[i] = max(maxs[i-1], arr[i])
        for i in range(len(arr)-2, -1, -1):
            mins[i] = min(mins[i+1], arr[i])
        res = 1
        for i in range(len(arr)-1):
            if maxs[i] <= mins[i+1]:
                res += 1
        return res