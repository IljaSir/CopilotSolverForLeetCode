class Solution:
    def removeDigit(self, number: str, digit: str) -> str:
        
        if number == digit:
            return ""
        if len(number) == 1:
            return number
        if number[0] == digit:
            return self.removeDigit(number[1:], digit)
        return number[0] + self.removeDigit(number[1:], digit)