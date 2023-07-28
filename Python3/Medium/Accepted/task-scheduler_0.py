class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        
        if n == 0:
            return len(tasks)
        task_dict = {}
        for task in tasks:
            if task in task_dict:
                task_dict[task] += 1
            else:
                task_dict[task] = 1
        task_list = sorted(task_dict.items(), key=lambda x: x[1], reverse=True)
        max_task = task_list[0][1]
        max_task_count = 0
        for task, num in task_list:
            if num == max_task:
                max_task_count += 1
            else:
                break
        return max(len(tasks), (max_task - 1) * (n + 1) + max_task_count)