class Solution:
    def longestMountain(self, arr: List[int]) -> int:
        
        n = len(arr)
        if n < 3:
            return 0
        up = [0]*n
        down = [0]*n
        for i in range(1, n):
            if arr[i] > arr[i-1]:
                up[i] = up[i-1] + 1
        for i in range(n-2, -1, -1):
            if arr[i] > arr[i+1]:
                down[i] = down[i+1] + 1
        ans = 0
        for i in range(n):
            if up[i] and down[i]:
                ans = max(ans, up[i]+down[i]+1)
        return ans