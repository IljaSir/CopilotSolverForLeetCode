class Solution:
    def isSelfCrossing(self, distance: List[int]) -> bool:
        
        x, y = 0, 0
        dx, dy = 0, 1
        for d in distance:
            x, y = x + dx * d, y + dy * d
            if dx == 0:
                if dy == 1:
                    if x < 0:
                        dx, dy = -1, 0
                    elif x > 0:
                        dx, dy = 1, 0
                else:
                    if x < 0:
                        dx, dy = 1, 0
                    elif x > 0:
                        dx, dy = -1, 0
            else:
                if dx == 1:
                    if y < 0:
                        dx, dy = 0, -1
                    elif y > 0:
                        dx, dy = 0, 1
                else:
                    if y < 0:
                        dx, dy = 0, 1
                    elif y > 0:
                        dx, dy = 0, -1
        return x == 0 and y == 0