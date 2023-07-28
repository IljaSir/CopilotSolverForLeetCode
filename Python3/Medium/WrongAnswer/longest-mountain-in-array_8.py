class Solution:
    def longestMountain(self, arr: List[int]) -> int:
        
        if len(arr) < 3:
            return 0
        i = 0
        j = 1
        res = 0
        while j < len(arr):
            if arr[j] == arr[j-1]:
                i = j
                j += 1
            elif arr[j] < arr[j-1]:
                if i != j - 1:
                    while j < len(arr) and arr[j] < arr[j-1]:
                        j += 1
                    res = max(res, j - i)
                i = j
                j += 1
            else:
                j += 1
        return res