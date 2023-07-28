class Solution:
    def freqAlphabets(self, s: str) -> str:
        
        # 1st solution
        # 32ms, 14.6MB (91.18%, 100%)
        s = s.replace('#', ' ')
        s = s.split()
        s = [int(x) for x in s]
        s = [chr(x+96) for x in s]
        s = ''.join(s)
        return s

        # 2nd solution
        # 28ms, 14.6MB (99.98%, 100%)
        i = 0
        res = ''
        while i < len(s):
            if i < len(s)-2 and s[i+2] == '#':
                res += chr(int(s[i:i+2])+96)
                i += 3
            else:
                res += chr(int(s[i])+96)
                i += 1
        return res