class Solution:
    def minimumJumps(self, forbidden: List[int], a: int, b: int, x: int) -> int:
        
        
        # BFS
        # Time  complexity: O(N+A+B), where N is the number of forbidden positions, and A, B are the maximum forward and backward jump lengths.
        # Space complexity: O(N+A+B), the size of the queue.
        queue = deque()
        visited = set()
        queue.append((0, False))
        steps = 0
        while queue:
            for _ in range(len(queue)):
                pos, backward = queue.popleft()
                if pos == x:
                    return steps
                for next_pos, next_backward in ((pos+a, False), (pos-b, True)):
                    if 0 <= next_pos < 6000 and next_pos not in forbidden and (next_pos, next_backward) not in visited:
                        visited.add((next_pos, next_backward))
                        if not next_backward or next_pos + b < 6000:
                            queue.append((next_pos, next_backward))
            steps += 1
        return -1