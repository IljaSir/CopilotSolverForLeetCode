class Solution:
    def longestMountain(self, arr: List[int]) -> int:
        
        if len(arr) < 3:
            return 0
        max_len = 0
        for i in range(1, len(arr)-1):
            if arr[i] > arr[i-1] and arr[i] > arr[i+1]:
                l = i
                r = i
                while l > 0 and arr[l] > arr[l-1]:
                    l -= 1
                while r < len(arr)-1 and arr[r] > arr[r+1]:
                    r += 1
                max_len = max(max_len, r-l+1)
        return max_len