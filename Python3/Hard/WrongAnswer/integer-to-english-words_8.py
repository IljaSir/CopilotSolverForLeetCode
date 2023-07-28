class Solution:
    def numberToWords(self, num: int) -> str:
        
        if num == 0:
            return 'Zero'
        # 0 ~ 19
        less_than_twenty = ['One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten', 'Eleven', 'Twelve', 'Thirteen', 'Fourteen', 'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen']
        # 20, 30, 40, 50, 60, 70, 80, 90
        tens = ['Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety']
        # 100, 1000, 1000000, 1000000000
        thousands = ['Hundred', 'Thousand', 'Million', 'Billion']
        def helper(num):
            if num == 0:
                return []
            elif num < 20:
                return [less_than_twenty[num - 1] + ' ']
            elif num < 100:
                return [tens[num // 10 - 2] + ' '] + helper(num % 10)
            else:
                return [less_than_twenty[num // 100 - 1] + ' Hundred '] + helper(num % 100)
        res = []
        for i in range(len(thousands)):
            if num % 1000 != 0:
                res = helper(num % 1000) + [thousands[i] + ' '] + res
            num //= 1000
        return ''.join(res).strip()