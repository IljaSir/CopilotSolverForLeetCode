class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        
        if len(hand) % groupSize != 0:
            return False
        if groupSize == 1:
            return True
        hand.sort()
        d = {}
        for i in hand:
            if i in d:
                d[i] += 1
            else:
                d[i] = 1
        for i in hand:
            if d[i] > 0:
                for j in range(i, i + groupSize):
                    if j not in d or d[j] == 0:
                        return False
                    d[j] -= 1
        return True