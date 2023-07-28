class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        res = []
        p = sorted(p)
        for i in range(len(s)-len(p)+1):
            if sorted(s[i:i+len(p)]) == p:
                res.append(i)
        return res