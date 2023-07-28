class Solution:
    def captureForts(self, forts: List[int]) -> int:
        
        n = len(forts)
        if n == 1:
            return 0
        if n == 2:
            return 1 if forts[0] == 0 and forts[1] == 0 else 0
        if n == 3:
            return 2 if forts[0] == 0 and forts[1] == 0 and forts[2] == 0 else 0
        left = [0] * n
        right = [0] * n
        for i in range(n):
            if i == 0:
                left[i] = 1 if forts[i] == 0 else 0
            else:
                left[i] = left[i - 1] + 1 if forts[i] == 0 else 0
        for i in range(n - 1, -1, -1):
            if i == n - 1:
                right[i] = 1 if forts[i] == 0 else 0
            else:
                right[i] = right[i + 1] + 1 if forts[i] == 0 else 0
        res = 0
        for i in range(n):
            if forts[i] == 1:
                res = max(res, left[i] + right[i] - 1)
        return res