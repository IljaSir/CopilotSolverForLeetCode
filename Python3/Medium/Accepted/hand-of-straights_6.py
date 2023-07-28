class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        
        
        if len(hand) % groupSize != 0:
            return False
        
        hand.sort()
        groups = {}
        for card in hand:
            if card not in groups:
                groups[card] = 1
            else:
                groups[card] += 1
        
        for card in hand:
            if groups[card] > 0:
                for i in range(groupSize):
                    if card + i not in groups or groups[card + i] == 0:
                        return False
                    else:
                        groups[card + i] -= 1
        return True