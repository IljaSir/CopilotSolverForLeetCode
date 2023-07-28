class Solution:
    def numTilePossibilities(self, tiles: str) -> int:
        
        
        def backtrack(tiles, path):
            if path:
                result.add(path)
            for i in range(len(tiles)):
                backtrack(tiles[:i] + tiles[i+1:], path + tiles[i])
        
        result = set()
        backtrack(tiles, '')
        return len(result)