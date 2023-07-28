class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        
        d = {}
        for i in range(len(s)-9):
            if s[i:i+10] not in d:
                d[s[i:i+10]] = 1
            else:
                d[s[i:i+10]] += 1
        return [k for k,v in d.items() if v > 1]