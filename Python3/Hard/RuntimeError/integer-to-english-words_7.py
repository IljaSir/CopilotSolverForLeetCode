class Solution:
    def numberToWords(self, num: int) -> str:
        
        self._ones = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"]
        self._teens = ["Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        self._tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        self._thousands = ["", "Thousand", "Million", "Billion"]
        if num == 0:
            return "Zero"
        result = []
        for i in range(len(self._thousands)):
            if num % 1000 != 0:
                result.insert(0, self._helper(num % 1000) + self._thousands[i])
            num //= 1000
        return " ".join(result)