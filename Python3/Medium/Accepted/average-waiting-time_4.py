class Solution:
    def averageWaitingTime(self, customers: List[List[int]]) -> float:
        
        total = 0
        end = 0
        for customer in customers:
            if customer[0] > end:
                end = customer[0]
            end += customer[1]
            total += end - customer[0]
        return total / len(customers)