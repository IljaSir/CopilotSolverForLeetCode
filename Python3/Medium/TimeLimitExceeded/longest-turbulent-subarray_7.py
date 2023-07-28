class Solution:
    def maxTurbulenceSize(self, arr: List[int]) -> int:
        
        res = 1
        i = 0
        n = len(arr)
        while i < n:
            j = i
            if j + 1 < n and arr[j] == arr[j + 1]:
                j += 1
            elif j + 1 < n and arr[j] < arr[j + 1]:
                while j + 1 < n and arr[j] < arr[j + 1]:
                    j += 1
            elif j + 1 < n and arr[j] > arr[j + 1]:
                while j + 1 < n and arr[j] > arr[j + 1]:
                    j += 1
            res = max(res, j - i + 1)
            i = j
        return res