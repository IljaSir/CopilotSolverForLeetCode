class Solution:
    def findSpecialInteger(self, arr: List[int]) -> int:
        
        n = len(arr)
        if n == 1:
            return arr[0]
        if n == 2:
            return arr[0] if arr[0] == arr[1] else -1
        half = n // 2
        for i in range(half, n):
            if arr[i] == arr[i-half]:
                return arr[i]
        return -1