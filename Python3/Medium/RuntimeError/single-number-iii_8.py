class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        
        # bit manipulation
        # a ^ a = 0
        # a ^ 0 = a
        # a ^ b ^ a = a ^ a ^ b = 0 ^ b = b
        # a ^ b ^ c = (a ^ b) ^ c
        # a ^ b ^ c = a ^ (b ^ c)
        # a ^ b ^ c = a ^ c ^ b
        # a ^ b ^ c = c ^ b ^ a
        # a ^ a = 0
        # a ^ 0 = a
        # a ^ b ^ a = a ^ a ^ b = 0 ^ b = b
        # a ^ b ^ c = (a ^ b) ^ c
        # a ^ b ^ c = a ^ (b ^ c)
        # a ^ b ^ c = a ^ c ^ b
        # a ^ b ^ c = c ^ b ^ a
        # a ^ b ^ c = c ^ a ^ b
        # a ^ b ^ c = b ^ c ^ a
        # a ^ b ^ c = b ^ a ^ c
        # a ^ b ^ c = b ^ c ^ a
        # a ^ b ^ c = c ^ b ^ a
        # a ^ b ^ c = c ^ a ^ b
        # a ^ b ^ c = b ^ c ^ a
        # a ^ b ^ c = b ^ a ^ c
        # a ^ b ^ c = b ^ c ^ a
        # a ^ b ^ c = c ^ b ^ a
        # a ^ b ^ c = c ^ a ^ b
        # a ^ b ^ c = b ^ c ^ a
        # a ^ b ^ c = b ^ a ^ c
        # a ^ b ^ c = b ^ c ^ a
        # a ^ b ^ c = c ^ b ^ a
        # a ^ b ^ c = c ^ a ^ b
        # a ^ b ^ c = b ^ c ^ a
        # a ^ b ^ c = b ^ a ^ c
        # a ^ b ^ c = b ^ c ^ a
        # a ^ b ^ c = c ^ b ^ a
        # a ^ b ^ c = c ^ a ^ b
        # a ^