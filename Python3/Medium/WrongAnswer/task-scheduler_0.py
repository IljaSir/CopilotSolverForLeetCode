class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        
        task_count = {}
        for task in tasks:
            if task in task_count:
                task_count[task] += 1
            else:
                task_count[task] = 1
        task_count = sorted(task_count.items(), key=lambda x: x[1], reverse=True)
        max_count = task_count[0][1]
        res = (max_count - 1) * (n + 1)
        for i in range(1, len(task_count)):
            if task_count[i][1] == max_count:
                res += 1
            else:
                break
        return max(res, len(tasks))