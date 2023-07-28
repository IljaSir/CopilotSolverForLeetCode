class Solution:
    def minimizeXor(self, num1: int, num2: int) -> int:
        
        # Find the number of set bits in num2
        # Find the number of set bits in num1
        # If the number of set bits in num2 is greater than the number of set bits in num1
        #   Find the difference between the two numbers
        #   Add the difference to num1
        #   Return num1
        # If the number of set bits in num1 is greater than the number of set bits in num2
        #   Find the difference between the two numbers
        #   Subtract the difference from num1
        #   Return num1
        # If the number of set bits in num1 and num2 are equal
        #   Return num1 XOR num2
        pass