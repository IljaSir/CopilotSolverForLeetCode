class Solution:
    def averageWaitingTime(self, customers: List[List[int]]) -> float:
        
        t = 0
        s = 0
        for a, b in customers:
            t = max(t, a) + b
            s += t - a
        return s / len(customers)