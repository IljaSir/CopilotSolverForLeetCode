class Solution:
    def longestMountain(self, arr: List[int]) -> int:
        
        if len(arr) < 3: return 0
        ans = 0
        i = 0
        while i < len(arr) - 1:
            j = i
            while j < len(arr) - 1 and arr[j] < arr[j + 1]:
                j += 1
            k = j
            while k < len(arr) - 1 and arr[k] > arr[k + 1]:
                k += 1
            if i < j and j < k:
                ans = max(ans, k - i + 1)
            i = max(j, k)
        return ans