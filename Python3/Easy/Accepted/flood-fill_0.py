class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        
        def dfs(i, j, color):
            image[i][j] = color
            for x, y in directions:
                new_i, new_j = i + x, j + y
                if 0 <= new_i < len(image) and 0 <= new_j < len(image[0]) and image[new_i][new_j] == old_color:
                    dfs(new_i, new_j, color)
        old_color = image[sr][sc]
        if old_color == color:
            return image
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        dfs(sr, sc, color)
        return image