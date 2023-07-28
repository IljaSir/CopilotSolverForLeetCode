class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        
        # O(n^2)
        # res = 0
        # for i in range(len(arr)):
        #     for j in range(i, len(arr)):
        #         res += min(arr[i:j+1])
        # return res % (10**9 + 7)
        # O(n)
        res = 0
        stack = []
        for i, a in enumerate(arr):
            while stack and stack[-1][1] > a:
                stack.pop()
            if stack:
                res += a * (i - stack[-1][0]) + stack[-1][2]
            else:
                res += a * (i + 1)
            stack.append([i, a, res])
        return res % (10**9 + 7)