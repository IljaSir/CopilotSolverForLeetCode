class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        
        maxs = [arr[0]]
        for i in range(1, len(arr)):
            maxs.append(max(arr[i], maxs[i-1]))
        mins = [arr[-1]]
        for i in range(len(arr)-2, -1, -1):
            mins.append(min(arr[i], mins[-1]))
        mins = mins[::-1]
        res = 1
        for i in range(len(arr)-1):
            if maxs[i] <= mins[i+1]:
                res += 1
        return res