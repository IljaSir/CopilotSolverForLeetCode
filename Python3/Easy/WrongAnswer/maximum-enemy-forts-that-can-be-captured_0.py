class Solution:
    def captureForts(self, forts: List[int]) -> int:
        
        n = len(forts)
        left = [0] * n
        right = [0] * n
        for i in range(n):
            if forts[i] == 0:
                left[i] = 1
        for i in range(1, n):
            left[i] += left[i-1]
        for i in range(n-2, -1, -1):
            right[i] = right[i+1]
            if forts[i] == 0:
                right[i] += 1
        res = 0
        for i in range(n):
            if forts[i] == 1:
                res = max(res, left[i] + right[i])
        return res