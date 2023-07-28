class Solution:
    def findMaximumXOR(self, nums: List[int]) -> int:
        
        max_num = max(nums)
        max_length = len(bin(max_num)) - 2
        nums = [[(num >> i) & 1 for i in range(max_length)][::-1] for num in nums]
        root = {}
        for num in nums:
            node = root
            for bit in num:
                if bit not in node:
                    node[bit] = {}
                node = node[bit]
        max_xor = 0
        for num in nums:
            node = root
            curr_xor = 0
            for bit in num:
                if 1 - bit in node:
                    curr_xor = (curr_xor << 1) | 1
                    node = node[1 - bit]
                else:
                    curr_xor = curr_xor << 1
                    node = node[bit]
            max_xor = max(max_xor, curr_xor)
        return max_xor