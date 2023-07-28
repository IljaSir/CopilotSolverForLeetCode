class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        
        dead = set(deadends)
        if '0000' in dead:
            return -1
        q = collections.deque([('0000', 0)])
        seen = {'0000'}
        while q:
            node, step = q.popleft()
            if node == target:
                return step
            for i in range(4):
                for d in (-1, 1):
                    new = node[:i] + str((int(node[i]) + d) % 10) + node[i+1:]
                    if new not in seen and new not in dead:
                        q.append((new, step + 1))
                        seen.add(new)
        return -1