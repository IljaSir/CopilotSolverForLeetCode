class Solution:
    def minimumCardPickup(self, cards: List[int]) -> int:
        
        d = {}
        for i, e in enumerate(cards):
            if e not in d:
                d[e] = [i]
            else:
                d[e].append(i)
        ans = 10 ** 5 + 1
        for e in d:
            if len(d[e]) < 2:
                continue
            ans = min(ans, d[e][-1] - d[e][0] + 1)
        return -1 if ans == 10 ** 5 + 1 else ans