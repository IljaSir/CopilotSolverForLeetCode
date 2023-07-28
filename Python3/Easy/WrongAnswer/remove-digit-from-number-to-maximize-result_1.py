class Solution:
    def removeDigit(self, number: str, digit: str) -> str:
        
        i = number.find(digit)
        if i == -1:
            return number
        if i == 0:
            return number[1:]
        if i == len(number) - 1:
            return number[:-1]
        return max(number[:i] + number[i+1:], number[:i-1] + number[i:])