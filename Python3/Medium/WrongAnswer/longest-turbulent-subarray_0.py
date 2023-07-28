class Solution:
    def maxTurbulenceSize(self, arr: List[int]) -> int:
        
        n = len(arr)
        if n == 1:
            return 1
        if n == 2:
            if arr[0] == arr[1]:
                return 1
            else:
                return 2
        res = 1
        flag = 0
        for i in range(1, n):
            if arr[i] == arr[i - 1]:
                flag = i
            elif i == n - 1 or arr[i] > arr[i - 1] and arr[i] > arr[i + 1] or arr[i] < arr[i - 1] and arr[i] < arr[i + 1]:
                res = max(res, i - flag + 1)
                flag = i
        return res