class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        
        if '0000' in deadends:
            return -1
        if target == '0000':
            return 0
        from collections import deque
        q = deque([['0000', 0]])
        visited = set(deadends)
        while q:
            cur, step = q.popleft()
            for i in range(4):
                for j in [-1, 1]:
                    new = cur[:i] + str((int(cur[i]) + j) % 10) + cur[i + 1:]
                    if new in visited:
                        continue
                    if new == target:
                        return step + 1
                    visited.add(new)
                    q.append([new, step + 1])
        return -1