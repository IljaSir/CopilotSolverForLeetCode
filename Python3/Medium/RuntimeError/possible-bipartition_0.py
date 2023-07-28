class Solution:
    def possibleBipartition(self, n: int, dislikes: List[List[int]]) -> bool:
        
        if not dislikes:
            return True
        graph = {}
        for i in range(1, n+1):
            graph[i] = []
        for dislike in dislikes:
            graph[dislike[0]].append(dislike[1])
            graph[dislike[1]].append(dislike[0])
        colors = {}
        for i in range(1, n+1):
            if i not in colors:
                colors[i] = 0
                if not self.dfs(i, colors, graph):
                    return False
        return True