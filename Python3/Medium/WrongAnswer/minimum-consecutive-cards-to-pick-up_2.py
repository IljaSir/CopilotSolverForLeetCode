class Solution:
    def minimumCardPickup(self, cards: List[int]) -> int:
        
        n = len(cards)
        cards.sort()
        d = defaultdict(int)
        for i in range(n):
            d[cards[i]] += 1
        for i in range(n):
            if d[cards[i]] >= 2:
                return 2
        for i in range(n):
            for j in range(i+1, n):
                if cards[j] - cards[i] < n:
                    d[cards[j]] -= 1
                    if d[cards[j]] >= 2:
                        return j - i + 1
                    d[cards[j]] += 1
        return -1