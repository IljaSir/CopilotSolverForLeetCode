class Solution:
    def averageWaitingTime(self, customers: List[List[int]]) -> float:
        
        t = 0
        s = 0
        for i in range(len(customers)):
            if t > customers[i][0]:
                t += customers[i][1]
                s += t - customers[i][0]
            else:
                t = customers[i][0] + customers[i][1]
                s += customers[i][1]
        return s/len(customers)