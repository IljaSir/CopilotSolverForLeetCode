class Solution:
    def reverse(self, x: int) -> int:
        
        if x > 0:
            x = int(str(x)[::-1])
        else:
            x = int('-' + str(x)[1:][::-1])
        return x if x.bit_length() < 33 else 0