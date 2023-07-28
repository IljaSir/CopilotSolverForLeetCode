class Solution:
    def originalDigits(self, s: str) -> str:
        
        d = dict()
        for c in s:
            if c in d:
                d[c] += 1
            else:
                d[c] = 1
        # print(d)
        res = ''
        if 'z' in d:
            res += '0' * d['z']
            d['e'] -= d['z']
            d['r'] -= d['z']
            d['o'] -= d['z']
            del d['z']
        if 'w' in d:
            res += '2' * d['w']
            d['t'] -= d['w']
            d['o'] -= d['w']
            del d['w']
        if 'x' in d:
            res += '6' * d['x']
            d['s'] -= d['x']
            d['i'] -= d['x']
            del d['x']
        if 'g' in d:
            res += '8' * d['g']
            d['e'] -= d['g']
            d['i'] -= d['g']
            d['h'] -= d['g']
            d['t'] -= d['g']
            del d['g']
        if 'u' in d:
            res += '4' * d['u']
            d['f'] -= d['u']
            d['o'] -= d['u']
            d['r'] -= d['u']
            del d['u']
        if 'o' in d:
            res += '1' * d['o']
            d['n'] -= d['o']
            d['e'] -= d['o']
            del d['o']
        if 'r' in d:
            res += '3' * d['r']
            d['t'] -= d['r']
            d['h'] -= d['r']
            d['e'] -= 2 * d['r']
            del d['r']
        if 'f' in d:
            res += '5' * d['f']
            d['i'] -= d['f']
            d['v'] -= d['f']
            d['e'] -= d['f']
            del d['f']
        if 's' in d:
            res += '7' * d['s']
            d['e'] -= 2 * d['s