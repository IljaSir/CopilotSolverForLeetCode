class Solution:
    def minSwapsCouples(self, row: List[int]) -> int:
        
        N = len(row)
        row = [x//2 for x in row]
        ans = 0
        for i in range(0, N, 2):
            if row[i] == row[i+1]:
                continue
            for j in range(i+1, N):
                if row[i] == row[j]:
                    row[i+1], row[j] = row[j], row[i+1]
                    ans += 1
                    break
        return ans