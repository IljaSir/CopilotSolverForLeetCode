class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        
        def nextStatus(status):
            for i in range(4):
                x = int(status[i])
                for d in (-1, 1):
                    y = (x + d) % 10
                    yield status[:i] + str(y) + status[i+1:]
        dead = set(deadends)
        q = collections.deque([('0000', 0)])
        seen = {'0000'}
        while q:
            status, step = q.popleft()
            if status == target:
                return step
            if status in dead:
                continue
            for next_status in nextStatus(status):
                if next_status not in seen:
                    q.append((next_status, step + 1))
                    seen.add(next_status)
        return -1