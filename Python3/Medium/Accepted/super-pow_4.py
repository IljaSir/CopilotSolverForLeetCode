class Solution:
    def superPow(self, a: int, b: List[int]) -> int:
        
        def pow(a, b):
            if b == 0:
                return 1
            if b == 1:
                return a
            if b % 2 == 0:
                return pow(a * a % 1337, b // 2)
            else:
                return pow(a * a % 1337, b // 2) * a % 1337
        return pow(a, int("".join(map(str, b))))