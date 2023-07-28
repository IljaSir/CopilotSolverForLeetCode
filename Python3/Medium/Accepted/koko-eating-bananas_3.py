class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        
        def canFinish(piles, h, speed):
            time = 0
            for pile in piles:
                time += pile // speed
                if pile % speed != 0:
                    time += 1
            return time <= h
        minSpeed = 1
        maxSpeed = max(piles)
        while minSpeed < maxSpeed:
            speed = minSpeed + (maxSpeed - minSpeed) // 2
            if canFinish(piles, h, speed):
                maxSpeed = speed
            else:
                minSpeed = speed + 1
        return minSpeed