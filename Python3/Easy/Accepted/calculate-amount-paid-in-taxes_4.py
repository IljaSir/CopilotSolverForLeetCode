class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        
        i = 0
        while i < len(brackets) and brackets[i][0] < income:
            i += 1
        if i == 0:
            return income * brackets[0][1] / 100
        if i == len(brackets):
            return self.calculateTax(brackets, brackets[-1][0]) + (income - brackets[-1][0]) * brackets[-1][1] / 100
        return self.calculateTax(brackets, brackets[i - 1][0]) + (income - brackets[i - 1][0]) * brackets[i][1] / 100