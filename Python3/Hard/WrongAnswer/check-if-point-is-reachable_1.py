class Solution:
    def isReachable(self, targetX: int, targetY: int) -> bool:
        
        while targetX > 0 and targetY > 0:
            if targetX > targetY:
                targetX %= targetY
            else:
                targetY %= targetX
        return targetX + targetY == 1