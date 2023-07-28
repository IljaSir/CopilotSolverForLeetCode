class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        
        stack = []
        res = 0
        for i, x in enumerate(arr):
            count = 1
            while stack and stack[-1][0] >= x:
                count += stack.pop()[1]
            stack.append((x, count))
            res += x * count
        return res % (10**9 + 7)