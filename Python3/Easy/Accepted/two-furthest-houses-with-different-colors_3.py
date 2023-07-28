class Solution:
    def maxDistance(self, colors: List[int]) -> int:
        
        # 1. Find the first and last index of each color
        # 2. Iterate through the colors and calculate the distance
        # 3. Return the max distance
        color_map = {}
        for i, color in enumerate(colors):
            if color not in color_map:
                color_map[color] = [i, i]
            else:
                color_map[color][1] = i
        # print(color_map)
        max_distance = 0
        for color, indices in color_map.items():
            for other_color, other_indices in color_map.items():
                if color != other_color:
                    max_distance = max(max_distance, abs(indices[0] - other_indices[1]), abs(indices[1] - other_indices[0]))
        return max_distance