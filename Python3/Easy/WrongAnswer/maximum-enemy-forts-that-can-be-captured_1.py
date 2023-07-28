class Solution:
    def captureForts(self, forts: List[int]) -> int:
        
        if 1 not in forts:
            return 0
        n = len(forts)
        left = [0] * n
        right = [0] * n
        for i in range(n):
            if forts[i] == 1:
                left[i] = 1
            elif forts[i] == -1:
                left[i] = 0
            else:
                left[i] = left[i-1] + 1
        for i in range(n-1, -1, -1):
            if forts[i] == 1:
                right[i] = 1
            elif forts[i] == -1:
                right[i] = 0
            else:
                right[i] = right[i+1] + 1
        res = 0
        for i in range(n):
            if forts[i] == 1:
                res = max(res, left[i] + right[i])
        return res