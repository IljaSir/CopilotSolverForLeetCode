class Solution:
    def removeDigit(self, number: str, digit: str) -> str:
        
        n = len(number)
        for i in range(n):
            if number[i] == digit:
                return number[:i] + number[i + 1:]
        return number