class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        
        count = 0
        max_num = 0
        for i, num in enumerate(arr):
            max_num = max(max_num, num)
            if max_num == i:
                count += 1
        return count