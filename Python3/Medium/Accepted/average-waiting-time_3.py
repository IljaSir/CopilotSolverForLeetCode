class Solution:
    def averageWaitingTime(self, customers: List[List[int]]) -> float:
        
        ans, curr = 0, 0
        for a, t in customers:
            curr = max(curr, a) + t
            ans += curr - a
        return ans / len(customers)