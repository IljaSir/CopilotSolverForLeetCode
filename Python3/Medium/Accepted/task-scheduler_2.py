class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        
        if n == 0:
            return len(tasks)
        counts = [0] * 26
        for task in tasks:
            counts[ord(task) - ord('A')] += 1
        counts.sort()
        max_val = counts[25] - 1
        idle_slots = max_val * n
        for i in range(24, -1, -1):
            idle_slots -= min(counts[i], max_val)
        return idle_slots + len(tasks) if idle_slots > 0 else len(tasks)