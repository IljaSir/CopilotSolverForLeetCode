class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        left = 0
        right = len(arr) - 1
        while left < right:
            mid = (left + right) // 2
            if arr[mid] < x:
                left = mid + 1
            else:
                right = mid
        l = left
        r = left
        while r - l < k:
            if l == 0:
                return arr[:k]
            if r == len(arr):
                return arr[-k:]
            if abs(arr[l-1] - x) <= abs(arr[r] - x):
                l -= 1
            else:
                r += 1
        return arr[l:r]