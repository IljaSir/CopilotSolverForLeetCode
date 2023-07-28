class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        
        if len(hand) % groupSize != 0:
            return False
        hand = sorted(hand)
        while hand:
            first = hand[0]
            for i in range(groupSize):
                if first + i not in hand:
                    return False
                hand.remove(first + i)
        return True