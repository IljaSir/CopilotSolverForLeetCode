class Solution:
    def possibleBipartition(self, n: int, dislikes: List[List[int]]) -> bool:
        
        graph = [[] for _ in range(n)]
        for a, b in dislikes:
            graph[a-1].append(b-1)
            graph[b-1].append(a-1)
        color = [0] * n
        for i in range(n):
            if color[i] == 0:
                color[i] = 1
                q = [i]
                while q:
                    c = q.pop(0)
                    for j in graph[c]:
                        if color[j] == color[c]:
                            return False
                        if color[j] == 0:
                            color[j] = -color[c]
                            q.append(j)
        return True