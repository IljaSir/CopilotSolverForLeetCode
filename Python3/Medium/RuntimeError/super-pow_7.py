class Solution:
    def superPow(self, a: int, b: List[int]) -> int:
        
        # a^b % 1337
        # a^b % 1337 = (a % 1337)^b % 1337
        # a^b % 1337 = ((a % 1337) * (a % 1337))^(b/2) % 1337
        # a^b % 1337 = ((a % 1337) * (a % 1337))^(b/2) * (a % 1337)^(b%2) % 1337
        if len(b) == 1 and b[0] == 0:
            return 1
        if len(b) == 1 and b[0] == 1:
            return a % 1337
        last = b.pop()
        return self.pow(self.superPow(a, b), 10) * self.pow(a, last) % 1337