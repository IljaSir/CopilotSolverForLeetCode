class Solution:
    def countDifferentSubsequenceGCDs(self, nums: List[int]) -> int:
        
        def gcd(a, b):
            if a < b:
                a, b = b, a
            while b != 0:
                a, b = b, a % b
            return a
        nums = set(nums)
        res = 0
        for i in range(1, 2*10**5+1):
            if all(gcd(i, j) == i for j in nums):
                res += 1
        return res