class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        if len(s) < len(p):
            return []
        p = sorted(p)
        result = []
        for i in range(len(s) - len(p) + 1):
            if sorted(s[i:i + len(p)]) == p:
                result.append(i)
        return result