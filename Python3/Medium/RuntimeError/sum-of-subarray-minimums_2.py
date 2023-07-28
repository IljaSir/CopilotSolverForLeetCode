class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        
        # O(n^2)
        # ans = 0
        # for i in range(len(arr)):
        #     for j in range(i, len(arr)):
        #         ans += min(arr[i:j+1])
        # return ans % (10**9 + 7)

        # O(n)
        # stack = []
        # ans = 0
        # for i, a in enumerate(arr):
        #     while stack and stack[-1][0] > a:
        #         stack.pop()
        #     stack.append([a, i])
        #     ans += (i - stack[-1][1] + 1) * a
        # return ans % (10**9 + 7)

        # O(n)
        stack = []
        ans = 0
        for i, a in enumerate(arr):
            while stack and stack[-1][0] > a:
                _, j = stack.pop()
                ans += (j - stack[-1][1]) * a
            stack.append([a, i])
        while stack:
            _, j = stack.pop()
            ans += (j - stack[-1][1]) * arr[j]
        return ans % (10**9 + 7)