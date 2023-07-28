class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> List[str]:
        
        s1 = s1.split(' ')
        s2 = s2.split(' ')
        s1 = [i for i in s1 if s1.count(i) == 1]
        s2 = [i for i in s2 if s2.count(i) == 1]
        s1 = [i for i in s1 if i not in s2]
        s2 = [i for i in s2 if i not in s1]
        return s1 + s2