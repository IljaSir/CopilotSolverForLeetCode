class Solution:
    def longestMountain(self, arr: List[int]) -> int:
        
        if len(arr) < 3:
            return 0
        max_len = 0
        i = 1
        while i < len(arr) - 1:
            if arr[i-1] < arr[i] and arr[i] > arr[i+1]:
                l = i - 1
                r = i + 1
                while l > 0 and arr[l-1] < arr[l]:
                    l -= 1
                while r < len(arr) - 1 and arr[r] > arr[r+1]:
                    r += 1
                max_len = max(max_len, r - l + 1)
                i = r
            i += 1
        return max_len