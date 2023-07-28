class Solution:
    def bestClosingTime(self, customers: str) -> int:
        
        penalty = 0
        open_hours = 0
        for i in range(len(customers)):
            if customers[i] == 'Y':
                penalty += 1
            else:
                open_hours += 1
        best_penalty = penalty
        for i in range(len(customers)):
            if customers[i] == 'Y':
                penalty -= 1
            else:
                penalty += 1
            if penalty < best_penalty:
                best_penalty = penalty
        return open_hours - best_penalty