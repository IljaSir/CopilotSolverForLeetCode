class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        
        # find the xor of the two numbers
        xor = 0
        for num in nums:
            xor ^= num
        # find the first bit that is 1
        mask = 1
        while (xor & mask) == 0:
            mask <<= 1
        a, b = 0, 0
        for num in nums:
            if (num & mask) != 0:
                a ^= num
            else:
                b ^= num
        return [a, b]