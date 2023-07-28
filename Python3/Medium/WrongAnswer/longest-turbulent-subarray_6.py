class Solution:
    def maxTurbulenceSize(self, arr: List[int]) -> int:
        
        if len(arr) == 1:
            return 1
        if len(arr) == 2:
            return 2 if arr[0] != arr[1] else 1
        result = 1
        current = 1
        for i in range(1, len(arr) - 1):
            if arr[i - 1] > arr[i] < arr[i + 1] or arr[i - 1] < arr[i] > arr[i + 1]:
                current += 1
            else:
                result = max(result, current)
                if arr[i - 1] == arr[i] or arr[i] == arr[i + 1]:
                    current = 1
                else:
                    current = 2
        return max(result, current)