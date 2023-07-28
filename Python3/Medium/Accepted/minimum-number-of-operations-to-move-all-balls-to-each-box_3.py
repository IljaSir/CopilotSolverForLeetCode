class Solution:
    def minOperations(self, boxes: str) -> List[int]:
        
        n = len(boxes)
        dp = [0] * n
        for i in range(n):
            for j in range(n):
                if boxes[j] == '1':
                    dp[i] += abs(i - j)
        return dp