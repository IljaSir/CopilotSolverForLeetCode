class Solution:
    def isReachable(self, targetX: int, targetY: int) -> bool:
        
        while targetX > 0 and targetY > 0:
            if targetX < targetY:
                targetX, targetY = targetY, targetX
            if targetX % targetY == 0:
                return targetX // targetY % 2 == 1
            targetX %= targetY