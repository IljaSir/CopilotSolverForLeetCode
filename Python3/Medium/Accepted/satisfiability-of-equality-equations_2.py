class Solution:
    def equationsPossible(self, equations: List[str]) -> bool:
        
        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]
        def union(x, y):
            xroot = find(x)
            yroot = find(y)
            parent[xroot] = yroot
        parent = [i for i in range(26)]
        for e in equations:
            if e[1] == "=":
                union(ord(e[0]) - ord("a"), ord(e[3]) - ord("a"))
        for e in equations:
            if e[1] == "!" and find(ord(e[0]) - ord("a")) == find(ord(e[3]) - ord("a")):
                return False
        return True