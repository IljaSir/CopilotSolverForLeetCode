class Solution:
    def shiftingLetters(self, s: str, shifts: List[int]) -> str:
        
        res = []
        for i in range(len(shifts)-1, -1, -1):
            if i == len(shifts)-1:
                shifts[i] = shifts[i] % 26
            else:
                shifts[i] = (shifts[i] + shifts[i+1]) % 26
        for i in range(len(s)):
            res.append(chr((ord(s[i]) - 97 + shifts[i]) % 26 + 97))
        return ''.join(res)