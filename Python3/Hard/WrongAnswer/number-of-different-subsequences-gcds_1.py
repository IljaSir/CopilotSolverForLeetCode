class Solution:
    def countDifferentSubsequenceGCDs(self, nums: List[int]) -> int:
        
        def gcd(a, b):
            while b:
                a, b = b, a % b
            return a
        n = max(nums)
        cnt = [0] * (n + 1)
        for num in nums:
            cnt[num] += 1
        ans = 0
        for i in range(1, n + 1):
            if cnt[i] > 0:
                ans += 1
            for j in range(i + i, n + 1, i):
                if gcd(i, j) == i:
                    cnt[i] += cnt[j]
        return ans