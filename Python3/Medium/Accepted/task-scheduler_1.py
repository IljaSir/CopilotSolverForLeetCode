class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        
        if n == 0: return len(tasks)
        task_dict = {}
        for task in tasks:
            if task in task_dict:
                task_dict[task] += 1
            else:
                task_dict[task] = 1
        task_dict = sorted(task_dict.items(), key=lambda x:x[1], reverse=True)
        max_count = task_dict[0][1]
        max_count_tasks = 1
        for key, value in task_dict[1:]:
            if value == max_count:
                max_count_tasks += 1
            else:
                break
        return max(len(tasks), (max_count - 1) * (n + 1) + max_count_tasks)