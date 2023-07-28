class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        
        if len(hand) % groupSize != 0:
            return False
        hand.sort()
        while hand:
            first = hand.pop(0)
            for i in range(1, groupSize):
                try:
                    hand.remove(first + i)
                except ValueError:
                    return False
        return True