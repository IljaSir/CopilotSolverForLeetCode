class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        
        pre, res = 0, 0
        for i, v in enumerate(arr):
            pre = max(pre, v)
            if pre == i:
                res += 1
        return res