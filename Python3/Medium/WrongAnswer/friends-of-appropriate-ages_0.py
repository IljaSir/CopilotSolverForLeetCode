class Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        
        c = collections.Counter(ages)
        ages = sorted(c)
        res = 0
        for i, a in enumerate(ages):
            for b in ages[i:]:
                if b <= 0.5 * a + 7:
                    continue
                if a == b:
                    res += c[a] * (c[a] - 1)
                else:
                    res += c[a] * c[b]
        return res