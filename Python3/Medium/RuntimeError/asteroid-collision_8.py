class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        
        # print(asteroids)
        if len(asteroids) == 0:
            return []
        if len(asteroids) == 1:
            return asteroids
        if len(asteroids) == 2:
            if asteroids[0] > 0 and asteroids[1] < 0:
                if abs(asteroids[0]) == abs(asteroids[1]):
                    return []
                elif abs(asteroids[0]) > abs(asteroids[1]):
                    return [asteroids[0]]
                else:
                    return [asteroids[1]]
            else:
                return asteroids
        # print(asteroids)
        for i in range(len(asteroids)-1):
            if asteroids[i] > 0 and asteroids[i+1] < 0:
                if abs(asteroids[i]) == abs(asteroids[i+1]):
                    asteroids[i] = 0
                    asteroids[i+1] = 0
                elif abs(asteroids[i]) > abs(asteroids[i+1]):
                    asteroids[i+1] = 0
                else:
                    asteroids[i] = 0
        # print(asteroids)
        if 0 in asteroids:
            asteroids = [i for i in asteroids if i != 0]
        # print(asteroids)
        if len(asteroids) > 1:
            return self.asteroidCollision(asteroids)
        else:
            return asteroids