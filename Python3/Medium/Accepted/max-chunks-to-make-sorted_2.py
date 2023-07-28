class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        
        count = 0
        for i in range(len(arr)):
            if i == max(arr[:i+1]):
                count += 1
        return count