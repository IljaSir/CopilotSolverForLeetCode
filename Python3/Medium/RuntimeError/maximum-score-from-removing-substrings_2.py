class Solution:
    def maximumGain(self, s: str, x: int, y: int) -> int:
        
        if x > y:
            return self.maximumGain(s, y, x)
        elif x == y:
            return self.maximumGain(s, x, y - 1) + self.maximumGain(s, y, y)
        else:
            return self.maximumGain(s, x, y - 1) + self.maximumGain(s, y, y)