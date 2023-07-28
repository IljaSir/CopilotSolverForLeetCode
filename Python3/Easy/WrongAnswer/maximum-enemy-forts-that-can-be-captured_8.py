class Solution:
    def captureForts(self, forts: List[int]) -> int:
        
        n = len(forts)
        dp = [0]*n
        for i in range(n):
            if forts[i] == 1:
                dp[i] = 1
                for j in range(i-1, -1, -1):
                    if forts[j] == 0:
                        dp[i] += 1
                    else:
                        break
                for j in range(i+1, n):
                    if forts[j] == 0:
                        dp[i] += 1
                    else:
                        break
        return max(dp)