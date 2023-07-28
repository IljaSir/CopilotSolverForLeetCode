class Solution:
    def splitIntoFibonacci(self, num: str) -> List[int]:
        
        if len(num) < 3:
            return []
        self.res = []
        self.dfs(num, 0)
        return self.res