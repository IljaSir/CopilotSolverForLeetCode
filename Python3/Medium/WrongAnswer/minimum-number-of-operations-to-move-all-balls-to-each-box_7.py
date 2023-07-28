class Solution:
    def minOperations(self, boxes: str) -> List[int]:
        
        # Solution 1 - 184 ms
        """
        res = [0] * len(boxes)
        for i in range(len(boxes)):
            for j in range(len(boxes)):
                if boxes[j] == '1':
                    res[i] += abs(i - j)
        return res
        """
        # Solution 2 - 40 ms
        res = [0] * len(boxes)
        dp = [0] * len(boxes)
        for i in range(1, len(boxes)):
            dp[i] = dp[i - 1] + int(boxes[i - 1]) * (i - 1)
            res[i] = dp[i]
        dp = [0] * len(boxes)
        for i in range(len(boxes) - 2, -1, -1):
            dp[i] = dp[i + 1] + int(boxes[i + 1]) * (len(boxes) - 1 - i)
            res[i] = res[i] + dp[i]
        return res