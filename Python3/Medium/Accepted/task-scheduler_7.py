class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        
        # 1. count the number of each task
        # 2. find the max count
        # 3. find the number of tasks with max count
        # 4. return max(len(tasks), (max_count - 1) * (n + 1) + num_of_max_count)
        if not tasks:
            return 0
        counter = collections.Counter(tasks)
        max_count = max(counter.values())
        num_of_max_count = sum(1 for v in counter.values() if v == max_count)
        return max(len(tasks), (max_count - 1) * (n + 1) + num_of_max_count)