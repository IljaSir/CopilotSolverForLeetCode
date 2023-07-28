class Solution:
    def findLengthOfShortestSubarray(self, arr: List[int]) -> int:
        
        n = len(arr)
        i = 0
        while i < n - 1 and arr[i] <= arr[i + 1]:
            i += 1
        if i == n - 1:
            return 0
        j = n - 1
        while j > 0 and arr[j - 1] <= arr[j]:
            j -= 1
        res = min(n - i - 1, j)
        k = 0
        while k <= i and j < n:
            if arr[k] <= arr[j]:
                res = min(res, j - k - 1)
                k += 1
            else:
                j += 1
        return res