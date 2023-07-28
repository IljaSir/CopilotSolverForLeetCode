class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        
        
        if not matchsticks:
            return False
        
        matchsticks.sort(reverse=True)
        target = sum(matchsticks) // 4
        
        if target * 4 != sum(matchsticks):
            return False
        
        def dfs(idx, side):
            if side == 3:
                return True
            
            for i in range(idx, len(matchsticks)):
                if matchsticks[i] == 0:
                    continue
                if matchsticks[i] + matchsticks[idx] > target:
                    continue
                matchsticks[i] = 0
                if dfs(idx + 1, side + 1):
                    return True
                matchsticks[i] = matchsticks[idx]
                if matchsticks[idx] == 0:
                    return False
            return False
        
        return dfs(0, 0)