class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        
        if n == 0:
            return len(tasks)
        freq = [0] * 26
        for task in tasks:
            freq[ord(task) - ord('A')] += 1
        freq.sort()
        max_freq = freq.pop()
        idle_time = (max_freq - 1) * n
        while freq and idle_time > 0:
            idle_time -= min(max_freq - 1, freq.pop())
        idle_time = max(0, idle_time)
        return len(tasks) + idle_time