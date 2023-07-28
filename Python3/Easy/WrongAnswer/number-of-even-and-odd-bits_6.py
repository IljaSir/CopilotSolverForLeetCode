class Solution:
    def evenOddBit(self, n: int) -> List[int]:
        
        even, odd = 0, 0
        while n != 0:
            if n & 1 == 1:
                if n & 2 == 0:
                    even += 1
                else:
                    odd += 1
            n >>= 1
        return [even, odd]