class Solution:
    def numberToWords(self, num: int) -> str:
        
        if num == 0:
            return "Zero"
        self.digits = ["One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"]
        self.teens = ["Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        self.tens = ["Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        self.hundreds = ["Hundred"]
        self.thousands = ["Thousand", "Million", "Billion"]
        self.num = str(num)
        self.num = self.num[::-1]
        self.num = [self.num[i:i+3] for i in range(0, len(self.num), 3)]
        self.num = [i[::-1] for i in self.num]
        self.num = [i for i in self.num if i != '000']
        self.num = self.num[::-1]
        self.num = [self.int_to_english(i) for i in self.num]
        return " ".join(self.num)