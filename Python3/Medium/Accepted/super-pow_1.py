class Solution:
    def superPow(self, a: int, b: List[int]) -> int:
        
        if not b: return 1
        last = b.pop()
        return pow(self.superPow(a, b), 10, 1337) * pow(a, last, 1337) % 1337