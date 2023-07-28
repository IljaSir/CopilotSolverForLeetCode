class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        
        hand.sort()
        if len(hand) % groupSize != 0:
            return False
        while hand:
            i = 1
            while i < groupSize:
                if hand[i] == hand[0] + i:
                    i += 1
                else:
                    return False
            hand = hand[groupSize:]
        return True