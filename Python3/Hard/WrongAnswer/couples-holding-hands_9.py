class Solution:
    def minSwapsCouples(self, row: List[int]) -> int:
        
        n = len(row)
        couples = [None] * n
        for i in range(0, n, 2):
            couples[row[i]] = i
            couples[row[i+1]] = i+1
        ans = 0
        for i in range(0, n, 2):
            if couples[i] == i+1:
                continue
            j = couples[i+1]
            couples[row[j]] = couples[i]
            row[couples[i]] = row[j]
            ans += 1
        return ans