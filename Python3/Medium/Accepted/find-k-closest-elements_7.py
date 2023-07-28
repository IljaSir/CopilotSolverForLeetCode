class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        def find(arr, x):
            l, r = 0, len(arr) - 1
            while l < r:
                mid = (l + r) // 2
                if arr[mid] < x:
                    l = mid + 1
                else:
                    r = mid
            return l
        idx = find(arr, x)
        l, r = idx - 1, idx
        while r - l - 1 < k:
            if l < 0:
                r += 1
            elif r >= len(arr):
                l -= 1
            elif x - arr[l] <= arr[r] - x:
                l -= 1
            else:
                r += 1
        return arr[l + 1:r]