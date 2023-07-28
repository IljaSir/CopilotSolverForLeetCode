class Solution:
    def deckRevealedIncreasing(self, deck: List[int]) -> List[int]:
        
        deck.sort()
        ans = [deck.pop()]
        while deck:
            ans = [deck.pop()] + ans[-1:] + ans[:-1]
        return ans