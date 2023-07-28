class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        
        for i in range(len(asteroids)):
            if len(asteroids) == 1:
                break
            if i == len(asteroids) - 1:
                break
            if asteroids[i] > 0 and asteroids[i + 1] < 0:
                if asteroids[i] == abs(asteroids[i + 1]):
                    asteroids.pop(i)
                    asteroids.pop(i)
                    if i > 1:
                        i -= 2
                    else:
                        i -= 1
                elif asteroids[i] > abs(asteroids[i + 1]):
                    asteroids.pop(i + 1)
                    if i > 0:
                        i -= 1
                else:
                    asteroids.pop(i)
                    if i > 0:
                        i -= 1
        return asteroids