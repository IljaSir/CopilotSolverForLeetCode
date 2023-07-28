class Solution:
    def sumBase(self, n: int, k: int) -> int:
        
        # Convert to base k
        base_k = []
        while n > 0:
            n, r = divmod(n, k)
            base_k.append(r)
        # Convert to base 10
        base_10 = []
        for digit in base_k:
            base_10.append(int(str(digit), k))
        # Return sum of digits
        return sum(base_10)