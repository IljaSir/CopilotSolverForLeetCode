class Solution:
    def maxDistance(self, colors: List[int]) -> int:
        
        # The idea is to keep track of the last index of each color.
        # Then for each color, check the distance between the current index and the last index of the other colors.
        # Return the maximum distance.
        last_index = {}
        max_distance = 0
        for i, c in enumerate(colors):
            if c not in last_index:
                last_index[c] = i
            else:
                max_distance = max(max_distance, i - last_index[c])
                last_index[c] = i
        return max_distance