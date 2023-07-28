class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        
        n = len(arr)
        if n == 1:
            return 1
        left = [0] * n
        right = [0] * n
        left[0] = arr[0]
        for i in range(1, n):
            left[i] = max(left[i-1], arr[i])
        right[-1] = arr[-1]
        for i in range(n-2, -1, -1):
            right[i] = min(right[i+1], arr[i])
        res = 1
        for i in range(1, n):
            if left[i-1] <= right[i]:
                res += 1
        return res