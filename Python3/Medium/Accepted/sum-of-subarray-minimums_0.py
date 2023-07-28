class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        
        n = len(arr)
        left, right = [0] * n, [0] * n
        stack = []
        for i in range(n):
            count = 1
            while stack and stack[-1][0] > arr[i]:
                count += stack.pop()[1]
            stack.append([arr[i], count])
            left[i] = count
        stack = []
        for i in range(n - 1, -1, -1):
            count = 1
            while stack and stack[-1][0] >= arr[i]:
                count += stack.pop()[1]
            stack.append([arr[i], count])
            right[i] = count
        return sum(a * l * r for a, l, r in zip(arr, left, right)) % (10 ** 9 + 7)