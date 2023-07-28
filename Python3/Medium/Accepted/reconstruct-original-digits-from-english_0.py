class Solution:
    def originalDigits(self, s: str) -> str:
        
        count = collections.Counter(s)
        digits = collections.defaultdict(int)
        digits[0] = count['z']
        digits[2] = count['w']
        digits[4] = count['u']
        digits[6] = count['x']
        digits[8] = count['g']
        digits[3] = count['h'] - digits[8]
        digits[5] = count['f'] - digits[4]
        digits[7] = count['s'] - digits[6]
        digits[9] = count['i'] - digits[5] - digits[6] - digits[8]
        digits[1] = count['n'] - digits[7] - 2 * digits[9]
        return ''.join(str(i) * digits[i] for i in range(10))