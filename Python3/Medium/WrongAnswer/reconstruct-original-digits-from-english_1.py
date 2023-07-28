class Solution:
    def originalDigits(self, s: str) -> str:
        
        d = collections.Counter(s)
        res = []
        res.append(d['z'])
        res.append(d['w'])
        res.append(d['u'])
        res.append(d['x'])
        res.append(d['g'])
        res.append(d['o'] - res[0] - res[2] - res[4])
        res.append(d['r'] - res[0] - res[3])
        res.append(d['f'] - res[4])
        res.append(d['h'] - res[3])
        res.append(d['i'] - res[5] - res[6] - res[8])
        return ''.join([str(i) * res[i] for i in range(10)])