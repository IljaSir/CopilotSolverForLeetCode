class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        
        def get_next(s):
            for i in range(4):
                x = int(s[i])
                for d in (-1, 1):
                    y = (x + d) % 10
                    yield s[:i] + str(y) + s[i+1:]
        dead = set(deadends)
        queue = [('0000', 0)]
        seen = {'0000'}
        while queue:
            s, step = queue.pop(0)
            if s == target:
                return step
            if s in dead:
                continue
            for s2 in get_next(s):
                if s2 not in seen:
                    seen.add(s2)
                    queue.append((s2, step+1))
        return -1