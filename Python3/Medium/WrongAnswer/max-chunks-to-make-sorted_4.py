class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        
        n = len(arr)
        sorted_arr = sorted(arr)
        count = 0
        for i in range(n):
            if arr[i] == sorted_arr[i]:
                count += 1
        return count