class Solution:
    def fillCups(self, amount: List[int]) -> int:
        
        # This is the same as the leetcode problem "Minimum Number of Days to Disconnect Island"
        # https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/
        # The only difference is that in this problem, we can fill up more than one cup at a time.
        # The idea is to use a queue to store the states of the cups.
        # The state of the cups is represented as a string.
        # The queue is initialized with the starting state.
        # We use a set to store the visited states.
        # When the queue is empty, we return the number of steps.
        # The number of steps is the answer.
        # The time complexity is O(2^N).
        # The space complexity is O(2^N).
        queue = collections.deque([self.get_state(amount)])
        visited = set(queue)
        steps = 0
        while queue:
            for _ in range(len(queue)):
                state = queue.popleft()
                if self.is_done(state):
                    return steps
                for next_state in self.get_next_states(state):
                    if next_state not in visited:
                        queue.append(next_state)
                        visited.add(next_state)
            steps += 1
        return -1