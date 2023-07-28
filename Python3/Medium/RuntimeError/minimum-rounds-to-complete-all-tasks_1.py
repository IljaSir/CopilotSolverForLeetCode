class Solution:
    def minimumRounds(self, tasks: List[int]) -> int:
        
        task_count = Counter(tasks)
        task_count = sorted(task_count.items(), key=lambda x: x[0])
        total_tasks = 0
        for task in task_count:
            total_tasks += task[1]
        if total_tasks % 3 == 1:
            for task in task_count:
                if task[1] % 3 == 1:
                    task[1] -= 1
                    total_tasks -= 1
                    break
                elif task[1] % 3 == 2:
                    task[1] -= 2
                    total_tasks -= 2
                    break
                else:
                    continue
        elif total_tasks % 3 == 2:
            for task in task_count:
                if task[1] % 3 == 2:
                    task[1] -= 2
                    total_tasks -= 2
                    break
                elif task[1] % 3 == 1:
                    task[1] -= 1
                    total_tasks -= 1
                    break
                else:
                    continue
        if total_tasks == 0:
            return 0
        return total_tasks // 3