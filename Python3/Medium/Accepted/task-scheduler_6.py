class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        
        if n == 0: return len(tasks)
        task_count = collections.Counter(tasks)
        task_count = sorted(task_count.values(), reverse=True)
        max_count = task_count[0]
        count = 0
        for i in task_count:
            if i == max_count: count += 1
            else: break
        return max((max_count - 1) * (n + 1) + count, len(tasks))