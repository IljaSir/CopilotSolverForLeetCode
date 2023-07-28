class Solution:
    def superPow(self, a: int, b: List[int]) -> int:
        
        def powmod(a, b):
            if b == 0:
                return 1
            elif b == 1:
                return a % 1337
            elif b % 2 == 0:
                return powmod(a * a % 1337, b // 2)
            else:
                return powmod(a * a % 1337, b // 2) * a % 1337
        if not b:
            return 1
        return powmod(a, b.pop()) * powmod(10, len(b)) * self.superPow(powmod(a, 10), b) % 1337