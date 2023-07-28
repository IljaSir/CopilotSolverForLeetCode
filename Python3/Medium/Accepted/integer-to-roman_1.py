class Solution:
    def intToRoman(self, num: int) -> str:
        
        d = {1:'I', 4:'IV', 5:'V', 9:'IX', 10:'X', 40:'XL', 50:'L', 90:'XC', 100:'C', 400:'CD', 500:'D', 900:'CM', 1000:'M'}
        k = sorted(list(d.keys()), reverse=True)
        s = []
        while num > 0:
            for i in k:
                if num >= i:
                    s.append(d[i])
                    num -= i
                    break
        return ''.join(s)