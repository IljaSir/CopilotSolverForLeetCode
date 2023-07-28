class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        
        deadends = set(deadends)
        if "0000" in deadends:
            return -1
        if target == "0000":
            return 0
        def next_states(state):
            for i in range(4):
                for d in (-1, 1):
                    new_state = state[:i] + str((int(state[i]) + d) % 10) + state[i+1:]
                    if new_state not in deadends:
                        yield new_state
        queue = collections.deque([("0000", 0)])
        visited = {"0000"}
        while queue:
            state, depth = queue.popleft()
            for next_state in next_states(state):
                if next_state == target:
                    return depth + 1
                if next_state not in visited:
                    visited.add(next_state)
                    queue.append((next_state, depth + 1))
        return -1