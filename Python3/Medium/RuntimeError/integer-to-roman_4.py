class Solution:
    def intToRoman(self, num: int) -> str:
        
        # 1 2 3 4 5 6 7 8 9
        # I II III IV V VI VII VIII IX
        # 10 20 30 40 50 60 70 80 90
        # X XX XXX XL L LX LXX LXXX XC
        # 100 200 300 400 500 600 700 800 900
        # C CC CCC CD D DC DCC DCCC CM
        # 1000 2000 3000
        # M MM MMM
        s = str(num)
        l = len(s)
        res = ''
        for i in range(l):
            if s[i] == '0':
                continue
            if l - i == 4:
                res += s[i] + 'M'
            elif l - i == 3:
                res += self.getRoman(s[i], 'C', 'D', 'M')
            elif l - i == 2:
                res += self.getRoman(s[i], 'X', 'L', 'C')
            elif l - i == 1:
                res += self.getRoman(s[i], 'I', 'V', 'X')
        return res