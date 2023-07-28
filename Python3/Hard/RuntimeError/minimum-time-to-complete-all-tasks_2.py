class Solution:
    def findMinimumTime(self, tasks: List[List[int]]) -> int:
        
        tasks.sort(key=lambda x: (x[1], x[0]))
        return self.dfs(tasks, 0, 0, 0, {})