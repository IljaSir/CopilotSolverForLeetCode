class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        
        if x == y:
            return 0
        if x > y:
            x, y = y, x
        x = bin(x)[2:]
        y = bin(y)[2:]
        x = list(x)
        y = list(y)
        y = [0] * (len(x) - len(y)) + y
        x = [0] * (len(y) - len(x)) + x
        return sum([x[i] != y[i] for i in range(len(x))])