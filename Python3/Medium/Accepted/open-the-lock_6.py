class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        
        deadends = set(deadends)
        if '0000' in deadends:
            return -1
        queue = [('0000', 0)]
        seen = set()
        while queue:
            node, depth = queue.pop(0)
            if node == target:
                return depth
            if node in seen:
                continue
            seen.add(node)
            for i in range(4):
                for j in (-1, 1):
                    tmp = node[:i] + str((int(node[i]) + j) % 10) + node[i+1:]
                    if tmp not in seen and tmp not in deadends:
                        queue.append((tmp, depth + 1))
        return -1