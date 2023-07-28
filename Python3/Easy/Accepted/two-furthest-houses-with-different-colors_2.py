class Solution:
    def maxDistance(self, colors: List[int]) -> int:
        
        # 1. Find the first and last occurence of each color
        # 2. Find the maximum distance between two colors
        color_first_last = defaultdict(list)
        for i, color in enumerate(colors):
            if color not in color_first_last:
                color_first_last[color].append(i)
                color_first_last[color].append(i)
            else:
                color_first_last[color][1] = i
        max_distance = 0
        for color, first_last in color_first_last.items():
            for other_color, other_first_last in color_first_last.items():
                if color == other_color:
                    continue
                max_distance = max(max_distance, abs(first_last[0] - other_first_last[1]), abs(first_last[1] - other_first_last[0]))
        return max_distance