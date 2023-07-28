class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        
        stack = []
        res = 0
        for i, num in enumerate(arr):
            while stack and stack[-1][0] > num:
                res += stack.pop()[0] * i - stack[-1][1]
            stack.append((num, i * stack[-1][0] if stack else 0))
        return (res + sum(i * num for i, num in enumerate(arr, 1))) % (10**9 + 7)