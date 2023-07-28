class Solution:
    def maxTurbulenceSize(self, arr: List[int]) -> int:
        
        if len(arr) == 1:
            return 1
        if len(arr) == 2:
            return 2 if arr[0] != arr[1] else 1
        max_len = 0
        current_len = 1
        for i, num in enumerate(arr[1:]):
            if i == 0:
                if arr[i] != num:
                    current_len += 1
                else:
                    current_len = 1
                continue
            if arr[i] > arr[i-1] and num < arr[i]:
                current_len += 1
            elif arr[i] < arr[i-1] and num > arr[i]:
                current_len += 1
            else:
                if current_len > max_len:
                    max_len = current_len
                if arr[i] != num:
                    current_len = 2
                else:
                    current_len = 1
        if current_len > max_len:
            max_len = current_len
        return max_len