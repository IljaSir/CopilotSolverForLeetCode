class Solution:
    def averageWaitingTime(self, customers: List[List[int]]) -> float:
        
        ans = 0
        t = customers[0][0]
        for a, b in customers:
            if a > t:
                t = a
            t += b
            ans += t - a
        return ans / len(customers)