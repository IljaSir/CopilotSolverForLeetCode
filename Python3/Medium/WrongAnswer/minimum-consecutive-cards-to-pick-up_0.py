class Solution:
    def minimumCardPickup(self, cards: List[int]) -> int:
        
        count = collections.Counter(cards)
        return min([count[x] for x in count if count[x] > 1]) * 2 if [x for x in count if count[x] > 1] else -1