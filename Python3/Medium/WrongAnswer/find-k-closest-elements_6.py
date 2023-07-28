class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        if x <= arr[0]:
            return arr[:k]
        if x >= arr[-1]:
            return arr[-k:]
        idx = bisect.bisect_left(arr, x)
        if idx == len(arr):
            idx -= 1
        if arr[idx] == x:
            return arr[idx:idx+k]
        if idx == 0:
            idx = 1
        left = idx - 1
        right = idx
        while right - left < k:
            if left < 0:
                right += 1
                continue
            if right >= len(arr):
                left -= 1
                continue
            if abs(arr[left] - x) <= abs(arr[right] - x):
                left -= 1
            else:
                right += 1
        return arr[left+1:right]