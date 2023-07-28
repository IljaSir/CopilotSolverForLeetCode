class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> List[str]:
        
        s1 = s1.split()
        s2 = s2.split()
        d = {}
        for i in s1:
            if i in d:
                d[i] += 1
            else:
                d[i] = 1
        for i in s2:
            if i in d:
                d[i] += 1
            else:
                d[i] = 1
        ans = []
        for i in d:
            if d[i] == 1:
                ans.append(i)
        return ans