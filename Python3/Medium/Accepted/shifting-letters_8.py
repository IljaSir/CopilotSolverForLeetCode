class Solution:
    def shiftingLetters(self, s: str, shifts: List[int]) -> str:
        
        for i in range(len(shifts)-2,-1,-1):
            shifts[i]+=shifts[i+1]
        res = []
        for i in range(len(s)):
            res.append(chr((ord(s[i])-97+shifts[i])%26+97))
        return ''.join(res)