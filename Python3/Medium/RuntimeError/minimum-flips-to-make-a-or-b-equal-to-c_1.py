class Solution:
    def minFlips(self, a: int, b: int, c: int) -> int:
        
        
        a = bin(a)[2:]
        b = bin(b)[2:]
        c = bin(c)[2:]
        
        if len(a) > len(b):
            b = '0'*(len(a)-len(b)) + b
        if len(a) < len(b):
            a = '0'*(len(b)-len(a)) + a
        if len(a) > len(c):
            c = '0'*(len(a)-len(c)) + c
        if len(a) < len(c):
            a = '0'*(len(c)-len(a)) + a
        
        res = 0
        for i in range(len(a)):
            if c[i] == '1':
                if a[i] == '0' and b[i] == '0':
                    res += 1
            else:
                if a[i] == '1':
                    res += 1
                if b[i] == '1':
                    res += 1
        
        return res