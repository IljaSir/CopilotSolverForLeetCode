class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        
        # 1. Count the frequency of each task
        # 2. Find the max frequency
        # 3. Find the number of tasks with max frequency
        # 4. Calculate the minimum number of intervals
        # 5. Calculate the number of idle slots
        # 6. Calculate the total number of intervals
        # 7. Return the max of the two values
        freq = {}
        for task in tasks:
            if task not in freq:
                freq[task] = 1
            else:
                freq[task] += 1
        max_freq = max(freq.values())
        max_freq_tasks = sum(1 for task in freq if freq[task] == max_freq)
        min_intervals = (max_freq - 1) * (n + 1) + max_freq_tasks
        idle_slots = max(0, min_intervals - len(tasks))
        return len(tasks) + idle_slots