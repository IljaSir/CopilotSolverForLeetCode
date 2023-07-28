class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        
        cnt = collections.Counter(s1)
        n = len(s1)
        for i, c in enumerate(s2):
            cnt[c] -= 1
            if i >= n:
                cnt[s2[i-n]] += 1
            if all(v <= 0 for v in cnt.values()):
                return True
        return False