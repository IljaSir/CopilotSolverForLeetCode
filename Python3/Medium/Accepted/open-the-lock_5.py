class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        
        def nextNum(s):
            for i in range(4):
                x = int(s[i])
                for d in (-1, 1):
                    y = (x + d) % 10
                    yield s[:i] + str(y) + s[i+1:]
        dead = set(deadends)
        q = collections.deque([('0000', 0)])
        seen = {'0000'}
        while q:
            node, depth = q.popleft()
            if node == target:
                return depth
            if node in dead:
                continue
            for nei in nextNum(node):
                if nei not in seen:
                    seen.add(nei)
                    q.append((nei, depth + 1))
        return -1