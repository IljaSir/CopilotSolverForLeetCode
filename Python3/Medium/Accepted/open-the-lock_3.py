class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        
        deadends = set(deadends)
        if '0000' in deadends:
            return -1
        queue = collections.deque([('0000', 0)])
        visited = set()
        while queue:
            node, step = queue.popleft()
            if node == target:
                return step
            for i in range(4):
                for d in [-1, 1]:
                    new = node[:i] + str((int(node[i]) + d) % 10) + node[i+1:]
                    if new not in deadends and new not in visited:
                        queue.append((new, step + 1))
                        visited.add(new)
        return -1