class Solution:
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        
        index = 0
        for i in range(1, len(arr)):
            if arr[i] > arr[i-1]:
                index = i
            else:
                return index