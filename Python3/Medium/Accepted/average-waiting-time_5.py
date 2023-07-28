class Solution:
    def averageWaitingTime(self, customers: List[List[int]]) -> float:
        
        total = 0
        start = 0
        for arrival, time in customers:
            start = max(arrival, start)
            total += time + start - arrival
            start += time
        return total / len(customers)