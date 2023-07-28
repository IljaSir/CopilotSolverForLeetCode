class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        
        # print(s)
        res = []
        for i in range(len(s)-9):
            # print(i)
            if s[i:i+10] in s[i+1:]:
                res.append(s[i:i+10])
        return list(set(res))