class Solution:
    def longestMountain(self, arr: List[int]) -> int:
        
        if len(arr) < 3: return 0
        max_len = 0
        for i in range(1, len(arr) - 1):
            if arr[i] > arr[i - 1] and arr[i] > arr[i + 1]:
                left = i - 1
                right = i + 1
                while left - 1 >= 0 and arr[left - 1] < arr[left]:
                    left -= 1
                while right + 1 < len(arr) and arr[right + 1] < arr[right]:
                    right += 1
                max_len = max(max_len, right - left + 1)
        return max_len