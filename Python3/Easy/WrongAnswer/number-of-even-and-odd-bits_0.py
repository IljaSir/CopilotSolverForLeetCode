class Solution:
    def evenOddBit(self, n: int) -> List[int]:
        
        even = 0
        odd = 0
        for i, bit in enumerate(bin(n)[2:]):
            if bit == '1':
                if i % 2 == 0:
                    even += 1
                else:
                    odd += 1
        return [even, odd]