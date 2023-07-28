class Solution:
    def productQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        
        
        # 1. Compute powers
        powers = []
        while n > 0:
            powers.append(n)
            n = n & (n-1)
        
        # 2. Compute prefix sums
        prefix_sums = [0] * (len(powers) + 1)
        for i in range(len(powers)):
            prefix_sums[i+1] = prefix_sums[i] + powers[i]
        
        # 3. Compute products
        products = []
        for left, right in queries:
            products.append(prefix_sums[right+1] - prefix_sums[left])
        
        return products