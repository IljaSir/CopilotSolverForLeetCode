class Solution:
    def longestMountain(self, arr: List[int]) -> int:
        
        max_len = 0
        i = 1
        n = len(arr)
        while i < n:
            if arr[i] > arr[i-1]:
                j = i
                while j < n and arr[j] > arr[j-1]:
                    j += 1
                if j < n and arr[j] < arr[j-1]:
                    while j < n and arr[j] < arr[j-1]:
                        j += 1
                    max_len = max(max_len, j - i + 1)
                i = j
            else:
                i += 1
        return max_len