class Solution:
    def canReach(self, s: str, minJump: int, maxJump: int) -> bool:
        
        if s[-1] != '0':
            return False
        if len(s) == 1:
            return True
        if s[1] == '0':
            q = [1]
        else:
            q = []
        visited = set()
        while q:
            i = q.pop(0)
            if i == len(s) - 1:
                return True
            if i in visited:
                continue
            visited.add(i)
            for j in range(max(i + minJump, 1), min(i + maxJump + 1, len(s))):
                if s[j] == '0':
                    q.append(j)
        return False