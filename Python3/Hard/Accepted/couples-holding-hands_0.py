class Solution:
    def minSwapsCouples(self, row: List[int]) -> int:
        
        N = len(row)
        pos = [0] * N
        for i, x in enumerate(row):
            pos[x] = i
        ans = 0
        for i in range(0, N, 2):
            x = row[i]
            if row[i + 1] == (x ^ 1):
                continue
            ans += 1
            y = x ^ 1
            j = pos[y]
            row[i + 1], row[j] = row[j], row[i + 1]
            pos[row[i + 1]], pos[row[j]] = i + 1, j
        return ans