class Solution:
    def removeDigit(self, number: str, digit: str) -> str:
        
        n = len(number)
        if n == 2:
            if number[0] == digit:
                return number[1]
            else:
                return number[0]
        else:
            if number[0] == digit:
                return number[0] + self.removeDigit(number[1:], digit)
            else:
                return number[0] + self.removeDigit(number[1:], digit)