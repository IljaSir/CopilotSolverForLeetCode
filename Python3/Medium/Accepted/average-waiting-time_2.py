class Solution:
    def averageWaitingTime(self, customers: List[List[int]]) -> float:
        
        total = 0
        time = 0
        for a, t in customers:
            time = max(time, a) + t
            total += time - a
        return total / len(customers)