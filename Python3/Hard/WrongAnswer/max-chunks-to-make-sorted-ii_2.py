class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        
        res = 0
        max_num = 0
        for i, a in enumerate(arr):
            max_num = max(max_num, a)
            if max_num == i:
                res += 1
        return res