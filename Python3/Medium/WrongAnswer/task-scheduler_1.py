class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        
        # 1. Count the number of each task
        # 2. Sort the tasks by the count
        # 3. Find the max number of tasks.
        # 4. Find the number of tasks that have the same count as the max.
        # 5. Calculate the number of tasks that need to be done.
        # 6. Calculate the idle time.
        # 7. Add the idle time to the number of tasks that need to be done.
        # 8. Return the number of tasks that need to be done.
        # 9. End.
        # 1. Count the number of each task
        task_count = {}
        for task in tasks:
            task_count[task] = task_count.get(task, 0) + 1
        # 2. Sort the tasks by the count
        task_count = sorted(task_count.items(), key=lambda x: x[1], reverse=True)
        # 3. Find the max number of tasks.
        max_task_count = task_count[0][1]
        # 4. Find the number of tasks that have the same count as the max.
        max_task_count_count = 0
        for task, count in task_count:
            if count != max_task_count:
                break
            max_task_count_count += 1
        # 5. Calculate the number of tasks that need to be done.
        num_tasks = (max_task_count - 1) * (n + 1) + max_task_count_count
        # 6. Calculate the idle time.
        idle_time = max(0, num_tasks - len(tasks))
        # 7. Add the idle time to the number of tasks that need to be done.
        num_tasks += idle_time
        # 8. Return the number of tasks that need to be done.
        return num_tasks
        # 9. End.