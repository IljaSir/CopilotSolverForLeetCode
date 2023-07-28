class Solution:
    def maximumXOR(self, nums: List[int]) -> int:
        
        # 1. Find the maximum number in nums
        # 2. Find the length of the maximum number
        # 3. Initialize the maximum XOR to 0
        # 4. Iterate through the length of the maximum number
        # 5. Set the current bit to 1
        # 6. Set the current maximum XOR to the current maximum XOR left shifted by 1
        # 7. Add the current bit to the current maximum XOR
        # 8. Initialize a set to store the prefixes of the current maximum XOR
        # 9. Iterate through nums
        # 10. Add the current number left shifted by the length of the maximum number minus the current index to the set
        # 11. Iterate through nums
        # 12. If the current number XOR the current maximum XOR is in the set
        # 13. Return the current maximum XOR
        # 14. Subtract the current bit from the current maximum XOR
        # 15. Set the current bit to 0
        # 16. Return the current maximum XOR
        maximum_number = max(nums)
        length = len(bin(maximum_number)) - 2
        maximum_xor = 0
        for index in range(length):
            current_bit = 1
            maximum_xor <<= 1
            maximum_xor += current_bit
            prefixes = set()
            for number in nums:
                prefixes.add(number >> (length - index - 1))
            for number in nums:
                if (number ^ maximum_xor) in prefixes:
                    return maximum_xor
            maximum_xor -= current_bit
            current_bit = 0
        return maximum_xor