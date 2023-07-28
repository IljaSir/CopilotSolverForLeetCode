class Solution:
    def maxTurbulenceSize(self, arr: List[int]) -> int:
        
        if len(arr) == 1:
            return 1
        if len(arr) == 2:
            if arr[0] == arr[1]:
                return 1
            else:
                return 2
        max_len = 1
        current_len = 1
        for i in range(1, len(arr)):
            if i % 2 == 0:
                if arr[i] > arr[i - 1]:
                    current_len += 1
                else:
                    if arr[i] < arr[i - 1]:
                        current_len = 2
                    else:
                        current_len = 1
            else:
                if arr[i] < arr[i - 1]:
                    current_len += 1
                else:
                    if arr[i] > arr[i - 1]:
                        current_len = 2
                    else:
                        current_len = 1
            max_len = max(max_len, current_len)
        return max_len