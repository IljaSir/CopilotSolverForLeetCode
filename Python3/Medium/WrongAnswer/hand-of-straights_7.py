class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        
        if len(hand) % groupSize != 0:
            return False
        hand.sort()
        while len(hand) > 0:
            if hand[0] == hand[groupSize-1]:
                hand = hand[groupSize:]
            else:
                return False
        return True