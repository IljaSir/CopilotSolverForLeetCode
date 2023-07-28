class Solution:
    def asteroidsDestroyed(self, mass: int, asteroids: List[int]) -> bool:
        
        asteroids.sort()
        for asteroid in asteroids:
            mass -= asteroid
            if mass < 0:
                return False
        return True