class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        
        if not tasks:
            return 0
        if n == 0:
            return len(tasks)
        task_map = {}
        for task in tasks:
            if task in task_map:
                task_map[task] += 1
            else:
                task_map[task] = 1
        tasks = sorted(task_map.items(), key=lambda x: x[1], reverse=True)
        # print(tasks)
        max_task = tasks[0][1]
        max_task_count = 1
        for task in tasks[1:]:
            if task[1] == max_task:
                max_task_count += 1
            else:
                break
        # print(max_task, max_task_count)
        return max(len(tasks), (max_task - 1) * (n + 1) + max_task_count)