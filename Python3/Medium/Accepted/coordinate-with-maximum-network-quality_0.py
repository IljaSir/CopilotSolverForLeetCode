class Solution:
    def bestCoordinate(self, towers: List[List[int]], radius: int) -> List[int]:
        
        max_quality = 0
        max_quality_pos = None
        for x in range(51):
            for y in range(51):
                quality = 0
                for tower in towers:
                    tower_x, tower_y, tower_quality = tower
                    distance = math.sqrt((tower_x - x) ** 2 + (tower_y - y) ** 2)
                    if distance > radius:
                        continue
                    quality += tower_quality // (1 + distance)
                if quality > max_quality:
                    max_quality = quality
                    max_quality_pos = [x, y]
                elif quality == max_quality:
                    if max_quality_pos is None or x < max_quality_pos[0] or (x == max_quality_pos[0] and y < max_quality_pos[1]):
                        max_quality_pos = [x, y]
        return max_quality_pos