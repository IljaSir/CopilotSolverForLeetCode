class Solution:
    def numberToWords(self, num: int) -> str:
        
        if num == 0:
            return 'Zero'
        self.less_than_20 = ['One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten', 'Eleven', 'Twelve', 'Thirteen', 'Fourteen', 'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen']
        self.tens = ['Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety']
        self.thousands = ['Thousand', 'Million', 'Billion']
        res = []
        i = 0
        while num:
            if num % 1000:
                res.append(self.helper(num % 1000) + ' ' + self.thousands[i] if i else self.helper(num % 1000))
            num //= 1000
            i += 1
        return ' '.join(res[::-1])