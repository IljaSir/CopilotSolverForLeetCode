class Solution:
    def maxTurbulenceSize(self, arr: List[int]) -> int:
        
        n = len(arr)
        if n == 1:
            return 1
        if n == 2:
            return 2 if arr[0] != arr[1] else 1
        if n == 3:
            if arr[0] == arr[1] or arr[1] == arr[2]:
                return 1
            if arr[0] < arr[1] and arr[1] > arr[2]:
                return 3
            if arr[0] > arr[1] and arr[1] < arr[2]:
                return 3
            return 2
        i = 0
        j = 1
        max_len = 1
        while j < n - 1:
            if arr[j] == arr[j + 1]:
                max_len = max(max_len, j - i + 1)
                i = j + 1
                j = i + 1
                continue
            if arr[j] > arr[j + 1]:
                if arr[j - 1] < arr[j]:
                    j += 1
                else:
                    max_len = max(max_len, j - i + 1)
                    i = j
                    j = i + 1
            elif arr[j] < arr[j + 1]:
                if arr[j - 1] > arr[j]:
                    j += 1
                else:
                    max_len = max(max_len, j - i + 1)
                    i = j
                    j = i + 1
            else:
                j += 1
        return max(max_len, j - i + 1)