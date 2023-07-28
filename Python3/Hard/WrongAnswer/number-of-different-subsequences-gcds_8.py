class Solution:
    def countDifferentSubsequenceGCDs(self, nums: List[int]) -> int:
        
        def gcd(a, b):
            if a == b:
                return a
            if a < b:
                return gcd(a, b - a)
            return gcd(a - b, b)
        n = max(nums)
        a = [0] * (n + 1)
        for num in nums:
            a[num] = 1
        ans = 0
        for i in range(1, n + 1):
            if a[i]:
                g = i
                for j in range(i + i, n + 1, i):
                    if a[j]:
                        g = gcd(g, j)
                if g == i:
                    ans += 1
        return ans