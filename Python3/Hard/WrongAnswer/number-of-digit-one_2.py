class Solution:
    def countDigitOne(self, n: int) -> int:
        
        if n <= 0:
            return 0
        s = str(n)
        l = len(s)
        if l == 1:
            return 1
        return self.countDigitOne(int(s[1:])) + self.countDigitOne(int(s[0])) * 10 ** (l - 1) + int(s[1:]) + 1 if int(s[0]) > 1 else self.countDigitOne(int(s[1:])) + int(s[1:]) + 1