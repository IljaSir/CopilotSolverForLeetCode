class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        
        # 1. find the left most and right most position of each element
        # 2. calculate the result
        left = [0] * len(arr)
        right = [0] * len(arr)
        stack = []
        for i in range(len(arr)):
            while stack and arr[stack[-1]] > arr[i]:
                stack.pop()
            left[i] = stack[-1] if stack else -1
            stack.append(i)
        stack = []
        for i in range(len(arr) - 1, -1, -1):
            while stack and arr[stack[-1]] >= arr[i]:
                stack.pop()
            right[i] = stack[-1] if stack else len(arr)
            stack.append(i)
        res = 0
        for i in range(len(arr)):
            res += arr[i] * (i - left[i]) * (right[i] - i)
        return res % (10 ** 9 + 7)