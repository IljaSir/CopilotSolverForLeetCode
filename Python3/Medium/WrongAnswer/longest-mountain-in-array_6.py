class Solution:
    def longestMountain(self, arr: List[int]) -> int:
        
        if len(arr) < 3:
            return 0
        i = 0
        j = 1
        res = 0
        while j < len(arr):
            if arr[j] > arr[j-1]:
                j += 1
            elif arr[j] == arr[j-1]:
                i = j
                j += 1
            else:
                k = j
                while k < len(arr) and arr[k] < arr[k-1]:
                    k += 1
                if k > j:
                    res = max(res, k-i)
                i = k-1
                j = k
        return res