class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        
        res = []
        for i in range(len(s)-9):
            if s[i:i+10] in s[i+1:] and s[i:i+10] not in res:
                res.append(s[i:i+10])
        return res