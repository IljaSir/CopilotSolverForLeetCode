class Solution:
    def minSwapsCouples(self, row: List[int]) -> int:
        
        n = len(row)
        pos = [0] * n
        for i, v in enumerate(row):
            pos[v] = i
        res = 0
        for i in range(0, n, 2):
            if row[i] % 2 == 0:
                j = pos[row[i] + 1]
            else:
                j = pos[row[i] - 1]
            if i + 1 != j:
                row[i + 1], row[j] = row[j], row[i + 1]
                pos[row[i + 1]], pos[row[j]] = i + 1, j
                res += 1
        return res