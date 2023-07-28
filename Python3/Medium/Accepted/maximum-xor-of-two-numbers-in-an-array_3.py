class Solution:
    def findMaximumXOR(self, nums: List[int]) -> int:
        
        max_xor = 0
        for i in range(31, -1, -1):
            max_xor <<= 1
            prefixes = {num >> i for num in nums}
            max_xor += any(max_xor^1^p in prefixes for p in prefixes)
        return max_xor