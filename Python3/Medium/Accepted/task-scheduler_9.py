class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        
        if n == 0:
            return len(tasks)
        # Find the task with the most occurences
        count = collections.Counter(tasks)
        max_count = max(count.values())
        # Find how many tasks have the max count
        max_count_tasks = sum(1 for v in count.values() if v == max_count)
        # Calculate the minimum number of intervals
        intervals = (max_count - 1) * (n + 1) + max_count_tasks
        # If the number of intervals is less than the number of tasks, return the number of tasks
        return max(intervals, len(tasks))