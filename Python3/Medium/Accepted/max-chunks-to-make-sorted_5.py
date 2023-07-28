class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        
        res = 0
        for i, v in enumerate(arr):
            if i == max(arr[:i+1]):
                res += 1
        return res