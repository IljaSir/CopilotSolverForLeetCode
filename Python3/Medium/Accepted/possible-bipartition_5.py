class Solution:
    def possibleBipartition(self, n: int, dislikes: List[List[int]]) -> bool:
        
        g = [[] for _ in range(n)]
        for a, b in dislikes:
            g[a-1].append(b-1)
            g[b-1].append(a-1)
        color = [-1] * n
        for i in range(n):
            if color[i] == -1:
                color[i] = 0
                q = [i]
                while q:
                    c = q.pop()
                    for v in g[c]:
                        if color[v] == -1:
                            color[v] = 1 - color[c]
                            q.append(v)
                        elif color[v] == color[c]:
                            return False
        return True