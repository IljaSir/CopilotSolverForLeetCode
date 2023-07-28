class Solution:
    def minimumDifference(self, nums: List[int]) -> int:
        
        n = len(nums) // 2
        a = [0] * (2**n)
        for i in range(2**n):
            for j in range(n):
                if i & (1 << j):
                    a[i] += nums[j]
        b = [0] * (2**n)
        for i in range(2**n):
            for j in range(n):
                if i & (1 << j):
                    b[i] += nums[n+j]
        a.sort()
        b.sort()
        i, j = 0, 0
        ans = float('inf')
        while i < 2**n and j < 2**n:
            ans = min(ans, abs(a[i]-b[j]))
            if a[i] < b[j]:
                i += 1
            else:
                j += 1
        return ans