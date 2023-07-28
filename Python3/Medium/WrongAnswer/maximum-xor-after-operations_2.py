class Solution:
    def maximumXOR(self, nums: List[int]) -> int:
        
        # 1. Find the maximum value in nums
        # 2. Find the maximum bit length of the maximum value
        # 3. Find the maximum bit length of the bitwise XOR of all the elements in nums
        # 4. Iterate through the bit length of the maximum value
        # 5. Iterate through the elements in nums
        # 6. Iterate through the bit length of the bitwise XOR of all the elements in nums
        # 7. Check if the maximum bit length of the bitwise XOR of all the elements in nums is less than the maximum bit length of the maximum value
        # 8. Check if the bitwise AND of the bitwise XOR of all the elements in nums and the maximum value is equal to the bitwise XOR of all the elements in nums
        # 9. Return the bitwise XOR of all the elements in nums

        maximum_value = max(nums)
        maximum_value_bit_length = len(bin(maximum_value)) - 2
        maximum_bitwise_xor_bit_length = len(bin(maximum_value ^ nums[0])) - 2
        for i in range(1, len(nums)):
            maximum_bitwise_xor_bit_length = max(maximum_bitwise_xor_bit_length, len(bin(maximum_value ^ nums[i])) - 2)
        for i in range(maximum_value_bit_length):
            for j in range(len(nums)):
                for k in range(maximum_bitwise_xor_bit_length):
                    if maximum_bitwise_xor_bit_length < maximum_value_bit_length:
                        if (maximum_value ^ nums[j]) & maximum_value == maximum_value ^ nums[j]:
                            return maximum_value ^ nums[j]
        return maximum_value ^ nums[0]