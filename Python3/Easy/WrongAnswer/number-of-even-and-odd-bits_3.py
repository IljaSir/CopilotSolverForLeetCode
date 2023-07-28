class Solution:
    def evenOddBit(self, n: int) -> List[int]:
        
        b = bin(n)[2:]
        even = odd = 0
        for i, v in enumerate(b):
            if v == '1':
                if i % 2 == 0:
                    even += 1
                else:
                    odd += 1
        return [even, odd]