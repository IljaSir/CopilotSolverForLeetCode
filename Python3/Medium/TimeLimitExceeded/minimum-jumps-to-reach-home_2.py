class Solution:
    def minimumJumps(self, forbidden: List[int], a: int, b: int, x: int) -> int:
        
        
        visited = set()
        queue = deque([(0, False)])
        jumps = 0
        while queue:
            for _ in range(len(queue)):
                curr, back = queue.popleft()
                if curr == x:
                    return jumps
                if curr in forbidden or (curr, back) in visited:
                    continue
                visited.add((curr, back))
                queue.append((curr + a, False))
                if not back:
                    queue.append((curr - b, True))
            jumps += 1
        return -1