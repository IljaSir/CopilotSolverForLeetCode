class Solution:
    def superPow(self, a: int, b: List[int]) -> int:
        
        a %= 1337
        res = 1
        for i in b:
            res = self.pow(res, 10) * self.pow(a, i) % 1337
        return res