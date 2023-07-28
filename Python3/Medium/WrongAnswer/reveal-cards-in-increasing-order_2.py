class Solution:
    def deckRevealedIncreasing(self, deck: List[int]) -> List[int]:
        
        deck.sort()
        n = len(deck)
        res = [0] * n
        res[0] = deck[0]
        for i in range(1, n):
            res[i] = deck[i]
            res = res[-1:] + res[:-1]
        return res