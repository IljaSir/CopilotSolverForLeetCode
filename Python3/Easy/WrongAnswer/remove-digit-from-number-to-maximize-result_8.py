class Solution:
    def removeDigit(self, number: str, digit: str) -> str:
        
        # Remove the first occurrence of digit from number
        # and return the resulting string
        # Find the index of the first occurrence of digit in number
        index = number.find(digit)
        # Remove the digit from number
        number = number[:index] + number[index+1:]
        return number