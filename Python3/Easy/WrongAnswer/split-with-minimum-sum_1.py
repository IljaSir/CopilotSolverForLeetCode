class Solution:
    def splitNum(self, num: int) -> int:
        
        s = str(num)
        freq = {}
        for c in s:
            if c in freq:
                freq[c] += 1
            else:
                freq[c] = 1
        freq = sorted(freq.items(), key=lambda x: x[1])
        freq1 = []
        freq2 = []
        for c, f in freq:
            if f <= 1:
                freq1.append((c, f))
                freq2.append((c, f))
            elif f == 2:
                freq1.append((c, 1))
                freq2.append((c, 1))
            else:
                freq1.append((c, f // 2))
                freq2.append((c, f - f // 2))
        num1 = 0
        num2 = 0
        for c, f in freq1:
            num1 = num1 * 10 + int(c) * f
        for c, f in freq2:
            num2 = num2 * 10 + int(c) * f
        return num1 + num2