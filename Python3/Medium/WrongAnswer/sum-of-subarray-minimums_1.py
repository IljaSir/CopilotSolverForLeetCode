class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        
        n = len(arr)
        stack = []
        res = 0
        for i in range(n):
            count = 1
            while stack and stack[-1][0] > arr[i]:
                count += stack.pop()[1]
            stack.append((arr[i], count))
            res += arr[i] * count
        stack = []
        for i in range(n - 1, -1, -1):
            count = 1
            while stack and stack[-1][0] >= arr[i]:
                count += stack.pop()[1]
            stack.append((arr[i], count))
            res += arr[i] * count
        return res - sum(arr)