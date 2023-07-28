class Solution:
    def numberToWords(self, num: int) -> str:
        
        if num == 0:
            return 'Zero'
        self.digits = ['', 'One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine']
        self.tens = ['Ten', 'Eleven', 'Twelve', 'Thirteen', 'Fourteen', 'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen']
        self.twenty = ['Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety']
        self.thousands = ['Thousand', 'Million', 'Billion']
        self.res = []
        self.convert(num)
        return ' '.join(self.res)