class Solution:
    def minOperations(self, nums: List[int], numsDivide: List[int]) -> int:
        
        def gcd(a, b):
            while b:
                a, b = b, a % b
            return a
        g = reduce(gcd, numsDivide)
        for x in nums:
            g = gcd(g, x)
        return -1 if g > 1 else sum((x - 1) // g for x in nums)