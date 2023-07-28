class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        
        if len(hand) % groupSize != 0:
            return False
        hand.sort()
        while hand:
            first = hand.pop(0)
            for i in range(1, groupSize):
                if first + i not in hand:
                    return False
                hand.remove(first + i)
        return True