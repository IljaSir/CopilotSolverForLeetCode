class Solution:
    def countDifferentSubsequenceGCDs(self, nums: List[int]) -> int:
        
        def gcd(a,b):
            while b:
                a,b = b, a%b
            return a
        def get_factors(x):
            res = set()
            for i in range(1, int(x**0.5)+1):
                if x%i==0:
                    res.add(i)
                    res.add(x//i)
            return res
        nums = set(nums)
        mx = max(nums)
        res = 0
        for i in range(1, mx+1):
            if all(gcd(i, x)==i for x in nums):
                res += 1
        return res