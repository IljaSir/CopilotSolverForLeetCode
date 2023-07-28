class Solution:
    def shiftingLetters(self, s: str, shifts: List[int]) -> str:
        
        for i in range(len(shifts)-2,-1,-1):
            shifts[i] += shifts[i+1]
        res = ""
        for i in range(len(s)):
            res += chr(ord('a')+(ord(s[i])-ord('a')+shifts[i])%26)
        return res