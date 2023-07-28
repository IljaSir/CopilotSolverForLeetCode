class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        
        xor = 0
        for num in nums:
            xor ^= num
        mask = 1
        while (mask & xor) == 0:
            mask <<= 1
        a = b = 0
        for num in nums:
            if num & mask == 0:
                a ^= num
            else:
                b ^= num
        return [a, b]