class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        
        if not matchsticks:
            return False
        matchsticks.sort(reverse=True)
        perimeter = sum(matchsticks)
        if perimeter % 4 != 0:
            return False
        side = perimeter // 4
        if matchsticks[0] > side:
            return False
        for i in range(4):
            if not self.dfs(matchsticks, [0] * len(matchsticks), side, 0):
                return False
        return True