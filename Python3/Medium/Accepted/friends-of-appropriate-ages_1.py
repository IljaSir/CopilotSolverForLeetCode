class Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        
        count = collections.Counter(ages)
        res = 0
        for a in count:
            for b in count:
                if not (b <= 0.5 * a + 7 or b > a or b > 100 and a < 100):
                    res += count[a] * (count[b] - (a == b))
        return res