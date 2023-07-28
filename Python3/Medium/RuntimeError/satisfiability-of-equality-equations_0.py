class Solution:
    def equationsPossible(self, equations: List[str]) -> bool:
        
        uf = UnionFind(26)
        for eq in equations:
            if eq[1] == '=':
                uf.union(ord(eq[0]) - ord('a'), ord(eq[3]) - ord('a'))
        for eq in equations:
            if eq[1] == '!' and uf.find(ord(eq[0]) - ord('a')) == uf.find(ord(eq[3]) - ord('a')):
                return False
        return True