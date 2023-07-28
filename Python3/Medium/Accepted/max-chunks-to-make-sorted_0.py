class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        
        res = 0
        max_val = 0
        for i, n in enumerate(arr):
            max_val = max(max_val, n)
            if max_val == i:
                res += 1
        return res