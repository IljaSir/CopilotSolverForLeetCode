class Solution:
    def countDifferentSubsequenceGCDs(self, nums: List[int]) -> int:
        
        def gcd(a, b):
            while b:
                a, b = b, a % b
            return a
        maxn = max(nums)
        cnt = [0] * (maxn + 1)
        for num in nums:
            cnt[num] += 1
        ans = 0
        for i in range(1, maxn + 1):
            g = 0
            for j in range(i, maxn + 1, i):
                if cnt[j]:
                    g = gcd(g, j)
            ans += g == i
        return ans