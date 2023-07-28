class Solution:
    def platesBetweenCandles(self, s: str, queries: List[List[int]]) -> List[int]:
        
        # The idea is to find the leftmost candle and rightmost candle for each plate. Then we count the number of plates between the leftmost candle and rightmost candle.
        # To find the leftmost candle, we can use a stack. The stack stores the index of the candles.
        # To find the rightmost candle, we can use a stack. The stack stores the index of the candles.
        # To count the number of plates between the leftmost candle and rightmost candle, we can use a prefix sum.
        # Time complexity: O(n + m)
        # Space complexity: O(n)
        n = len(s)
        leftmost_candle = [0] * n
        rightmost_candle = [0] * n
        stack = []
        for i in range(n):
            if s[i] == "|":
                stack.append(i)
            else:
                leftmost_candle[i] = stack[-1] if stack else 0
        stack = []
        for i in range(n - 1, -1, -1):
            if s[i] == "|":
                stack.append(i)
            else:
                rightmost_candle[i] = stack[-1] if stack else n - 1
        prefix_sum = [0] * (n + 1)
        for i in range(n):
            if s[i] == "*":
                prefix_sum[leftmost_candle[i] + 1] += 1
                prefix_sum[rightmost_candle[i] + 1] -= 1
        for i in range(1, n + 1):
            prefix_sum[i] += prefix_sum[i - 1]
        ans = []
        for left, right in queries:
            ans.append(prefix_sum[right] - prefix_sum[left])
        return ans