class Solution:
    def reorderedPowerOf2(self, n: int) -> bool:
        
        
        def get_digit_count(n):
            digit_count = {}
            for c in str(n):
                digit_count[c] = digit_count.get(c, 0) + 1
            return digit_count
        
        digit_count = get_digit_count(n)
        for i in range(30):
            if digit_count == get_digit_count(1 << i):
                return True
        return False