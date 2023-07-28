class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> List[str]:
        
        s1 = s1.split()
        s2 = s2.split()
        s1c = Counter(s1)
        s2c = Counter(s2)
        s1c.subtract(s2c)
        return [x for x in s1c if s1c[x] == 1]