class Solution:
    def maxSatisfied(self, customers: List[int], grumpy: List[int], minutes: int) -> int:
        
        maxSatisfied = 0
        for i in range(len(customers)):
            if grumpy[i] == 0:
                maxSatisfied += customers[i]
        for i in range(len(customers) - minutes + 1):
            maxSatisfied += sum(customers[i:i+minutes]) * grumpy[i]
        return maxSatisfied