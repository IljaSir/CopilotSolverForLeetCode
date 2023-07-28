class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        
        # calculate the bitwise XOR of x and y
        # count the number of 1's in the result
        return bin(x ^ y).count("1")