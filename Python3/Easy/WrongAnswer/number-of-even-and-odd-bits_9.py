class Solution:
    def evenOddBit(self, n: int) -> List[int]:
        
        # binary representation of n
        binary = bin(n)[2:]
        # count the number of 1s in even and odd indices
        even = sum([1 for i, b in enumerate(binary) if b == '1' and i % 2 == 0])
        odd = sum([1 for i, b in enumerate(binary) if b == '1' and i % 2 == 1])
        return [even, odd]