class Solution:
    def totalHammingDistance(self, nums: List[int]) -> int:
        
        s = 0
        for i in range(32):
            x = 1 << i
            c = 0
            for n in nums:
                if n & x:
                    c += 1
            s += c * (len(nums) - c)
        return s