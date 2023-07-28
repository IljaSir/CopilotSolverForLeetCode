class Solution:
    def bestClosingTime(self, customers: str) -> int:
        
        n = len(customers)
        penalty = 0
        for i in range(n):
            if customers[i] == 'N':
                penalty += 1
        min_penalty = penalty
        min_time = 0
        for j in range(n):
            if customers[j] == 'Y':
                penalty += 1
            else:
                penalty -= 1
            if penalty < min_penalty:
                min_penalty = penalty
                min_time = j + 1
        return min_time