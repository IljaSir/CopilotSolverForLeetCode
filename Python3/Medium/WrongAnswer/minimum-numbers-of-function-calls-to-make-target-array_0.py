class Solution:
    def minOperations(self, nums: List[int]) -> int:
        
        res = 0
        for i in range(31):
            c = 0
            for num in nums:
                c += (num >> i) & 1
            res += c * (1 << i)
        return res