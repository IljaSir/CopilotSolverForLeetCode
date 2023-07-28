class Solution:
    def superPow(self, a: int, b: List[int]) -> int:
        
        def pow(a, b):
            if b == 0:
                return 1
            if b == 1:
                return a
            if b % 2 == 0:
                return pow(a, b//2) ** 2
            return pow(a, b//2) ** 2 * a
        return pow(a, int(''.join(map(str, b)))) % 1337