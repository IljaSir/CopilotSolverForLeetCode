class Solution:
    def shiftingLetters(self, s: str, shifts: List[List[int]]) -> str:
        
        res = []
        for i in range(len(shifts)):
            if i == 0:
                shifts[i][2] = shifts[i][2] % 26
            else:
                shifts[i][2] = (shifts[i][2] + shifts[i - 1][2]) % 26
        for i in range(len(s)):
            if i < shifts[0][0]:
                res.append(s[i])
            elif i > shifts[-1][1]:
                res.append(s[i])
            else:
                for j in range(len(shifts)):
                    if shifts[j][0] <= i <= shifts[j][1]:
                        if shifts[j][2] == 0:
                            res.append(s[i])
                        else:
                            res.append(chr(ord(s[i]) + shifts[j][2] if ord(s[i]) + shifts[j][2] <= ord('z') else ord(s[i]) + shifts[j][2] - 26))
        return ''.join(res)