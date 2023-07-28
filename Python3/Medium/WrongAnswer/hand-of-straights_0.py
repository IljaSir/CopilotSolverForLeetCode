class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        
        
        if groupSize == 1:
            return True
        
        if len(hand) % groupSize != 0:
            return False
        
        hand.sort()
        
        i = 0
        while i < len(hand):
            if hand[i] == -1:
                i += 1
                continue
            
            j = i + 1
            count = 1
            while j < len(hand):
                if hand[j] == -1:
                    j += 1
                    continue
                
                if hand[j] == hand[j-1] + 1:
                    count += 1
                    hand[j] = -1
                    if count == groupSize:
                        break
                else:
                    break
                j += 1
                
            if count != groupSize:
                return False
            
            i += 1
        return True