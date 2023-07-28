class Solution:
    def originalDigits(self, s: str) -> str:
        
        # zero: z
        # two: w
        # four: u
        # six: x
        # eight: g
        # one: o - zero - two - four
        # three: h - eight
        # five: f - four
        # seven: s - six
        # nine: i - five - six - eight
        # print(s)
        l = len(s)
        if l == 0:
            return ''
        if l == 1:
            return '0' if s == 'z' else ''
        if l == 2:
            return '2' if s == 'w' else ''
        if l == 3:
            return '4' if s == 'u' else ''
        if l == 4:
            return '6' if s == 'x' else ''
        if l == 5:
            return '8' if s == 'g' else ''
        if l == 6:
            return '1' if s == 'o' else ''
        if l == 7:
            return '3' if s == 'h' else ''
        if l == 8:
            return '5' if s == 'f' else ''
        if l == 9:
            return '7' if s == 's' else ''
        if l == 10:
            return '9' if s == 'i' else ''
        if l > 10:
            return ''