class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        
        MOD = 10**9 + 7
        stack = []
        res = 0
        for i in range(len(arr)):
            count = 1
            while stack and stack[-1][0] > arr[i]:
                count += stack.pop()[1]
            stack.append((arr[i], count))
            res += arr[i] * count
            res %= MOD
        return res