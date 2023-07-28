class Solution:
    def averageWaitingTime(self, customers: List[List[int]]) -> float:
        
        start = customers[0][0]
        end = start + customers[0][1]
        total = end - start
        for i in range(1, len(customers)):
            start = max(end, customers[i][0])
            end = start + customers[i][1]
            total += end - start
        return total / len(customers)