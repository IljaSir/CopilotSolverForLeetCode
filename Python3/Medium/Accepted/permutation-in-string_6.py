class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        
        if len(s2) < len(s1):
            return False
        s1count = collections.Counter(s1)
        s2count = collections.Counter(s2[:len(s1)])
        if s1count == s2count:
            return True
        for i in range(len(s1), len(s2)):
            s2count[s2[i]] += 1
            s2count[s2[i-len(s1)]] -= 1
            if s2count[s2[i-len(s1)]] == 0:
                del s2count[s2[i-len(s1)]]
            if s1count == s2count:
                return True
        return False