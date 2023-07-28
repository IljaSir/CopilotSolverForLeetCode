class Solution:
    def minimumCardPickup(self, cards: List[int]) -> int:
        
        # O(n) time, O(n) space
        # If the number of cards is odd, then you cannot have matching cards.
        # If the number of cards is even, then you must have matching cards.
        # The minimum number of cards to pick up is the number of cards minus the number of unique cards.
        if len(cards) % 2 != 0:
            return -1
        return len(cards) - len(set(cards))