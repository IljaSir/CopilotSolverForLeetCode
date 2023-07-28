class Solution:
    def numberToWords(self, num: int) -> str:
        
        if num == 0:
            return 'Zero'
        units = ['', 'One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine']
        tens = ['', 'Ten', 'Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety']
        teens = ['', 'Eleven', 'Twelve', 'Thirteen', 'Fourteen', 'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen']
        thousands = ['', 'Thousand', 'Million', 'Billion']
        def helper(num):
            if num == 0:
                return ''
            elif num < 10:
                return units[num] + ' '
            elif num < 20:
                return teens[num % 10] + ' '
            elif num < 100:
                return tens[num // 10] + ' ' + helper(num % 10)
            else:
                return units[num // 100] + ' Hundred ' + helper(num % 100)
        res = ''
        i = 0
        while num > 0:
            if num % 1000 != 0:
                res = helper(num % 1000) + thousands[i] + ' ' + res
            num //= 1000
            i += 1
        return res.strip()