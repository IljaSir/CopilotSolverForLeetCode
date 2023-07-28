class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        
        if len(hand) % groupSize != 0:
            return False
        hand.sort()
        while hand:
            first = hand.pop(0)
            for i in range(groupSize - 1):
                if first + i + 1 not in hand:
                    return False
                hand.remove(first + i + 1)
        return True