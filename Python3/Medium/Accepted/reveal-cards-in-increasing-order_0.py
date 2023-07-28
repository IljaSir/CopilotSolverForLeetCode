class Solution:
    def deckRevealedIncreasing(self, deck: List[int]) -> List[int]:
        
        deck.sort()
        res = [deck.pop()]
        while deck:
            res.insert(0, res.pop())
            res.insert(0, deck.pop())
        return res