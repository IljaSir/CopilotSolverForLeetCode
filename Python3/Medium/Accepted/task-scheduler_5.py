class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        
        task_count = collections.Counter(tasks)
        max_count = max(task_count.values())
        max_count_tasks = sum(1 for val in task_count.values() if val == max_count)
        return max(len(tasks), (max_count - 1) * (n + 1) + max_count_tasks)