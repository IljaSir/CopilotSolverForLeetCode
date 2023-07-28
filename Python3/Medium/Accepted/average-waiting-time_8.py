class Solution:
    def averageWaitingTime(self, customers: List[List[int]]) -> float:
        
        res, last = 0, 0
        for time, cost in customers:
            res += max(last, time) + cost - time
            last = max(last, time) + cost
        return res / len(customers)