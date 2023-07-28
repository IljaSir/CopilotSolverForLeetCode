class Solution:
    def hardestWorker(self, n: int, logs: List[List[int]]) -> int:
        
        employees = [0 for _ in range(n)]
        for i in range(len(logs)):
            if i == 0:
                employees[logs[i][0]] += logs[i][1]
            else:
                employees[logs[i][0]] += logs[i][1] - logs[i-1][1]
        max_time = max(employees)
        return employees.index(max_time)