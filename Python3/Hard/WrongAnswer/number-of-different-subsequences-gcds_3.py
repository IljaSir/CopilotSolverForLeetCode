class Solution:
    def countDifferentSubsequenceGCDs(self, nums: List[int]) -> int:
        
        def gcd(a, b):
            while b:
                a, b = b, a % b
            return a
        nums = set(nums)
        res = 0
        for x in range(1, 2 * 10**5 + 1):
            if any(x % y == 0 for y in nums):
                res += 1
                for y in nums:
                    if y > x:
                        break
                    if x % y == 0:
                        x = gcd(x, y)
        return res