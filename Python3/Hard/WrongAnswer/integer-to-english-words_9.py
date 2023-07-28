class Solution:
    def numberToWords(self, num: int) -> str:
        
        if num == 0:
            return "Zero"
        return self.numberToWords(num // 1000) + " Thousand" * (num % 1000 != 0) if num >= 1000 else self.numberToWords(num // 100) + " Hundred" * (num % 100 != 0) if num >= 100 else " " + self.numberToWords(num // 10) if num >= 20 else " " + ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"][num] if num >= 10 else " " + ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"][num] if num >= 20 else ""