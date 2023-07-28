class Solution:
    def intToRoman(self, num: int) -> str:
        
        roman = {
            1: 'I',
            4: 'IV',
            5: 'V',
            9: 'IX',
            10: 'X',
            40: 'XL',
            50: 'L',
            90: 'XC',
            100: 'C',
            400: 'CD',
            500: 'D',
            900: 'CM',
            1000: 'M'
        }
        s = ''
        while num > 0:
            for i in range(1, 4):
                if num >= 1000:
                    s += roman[1000]
                    num -= 1000
                elif num >= 900:
                    s += roman[900]
                    num -= 900
                elif num >= 500:
                    s += roman[500]
                    num -= 500
                elif num >= 400:
                    s += roman[400]
                    num -= 400
                elif num >= 100:
                    s += roman[100]
                    num -= 100
                elif num >= 90:
                    s += roman[90]
                    num -= 90
                elif num >= 50:
                    s += roman[50]
                    num -= 50
                elif num >= 40:
                    s += roman[40]
                    num -= 40
                elif num >= 10:
                    s += roman[10]
                    num -= 10
                elif num >= 9:
                    s += roman[9]
                    num -= 9
                elif num >= 5:
                    s += roman[5]
                    num -= 5
                elif num >= 4:
                    s += roman[4]
                    num -= 4
                elif num >= 1:
                    s += roman[1]
                    num -= 1
        return s