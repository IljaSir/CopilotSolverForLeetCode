class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        
        res = 0
        stack = []
        for i in range(len(arr)):
            while stack and arr[stack[-1]] > arr[i]:
                stack.pop()
            if not stack:
                left = i + 1
            else:
                left = i - stack[-1]
            stack.append(i)
            res += arr[i] * left
        stack = []
        for i in range(len(arr) - 1, -1, -1):
            while stack and arr[stack[-1]] >= arr[i]:
                stack.pop()
            if not stack:
                right = len(arr) - i
            else:
                right = stack[-1] - i
            stack.append(i)
            res += arr[i] * right
        return res % (10**9 + 7)