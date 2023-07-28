class Solution:
    def findLengthOfShortestSubarray(self, arr: List[int]) -> int:
        
        n = len(arr)
        if n == 1:
            return 0
        if n == 2:
            if arr[0] <= arr[1]:
                return 0
            else:
                return 1
        l = 0
        r = n - 1
        while l < r and arr[l] <= arr[l + 1]:
            l += 1
        if l == n - 1:
            return 0
        while r > l and arr[r] >= arr[r - 1]:
            r -= 1
        ans = min(n - l - 1, r)
        i = 0
        j = r
        while i <= l and j < n:
            if arr[j] >= arr[i]:
                ans = min(ans, j - i - 1)
                i += 1
            else:
                j += 1
        return ans