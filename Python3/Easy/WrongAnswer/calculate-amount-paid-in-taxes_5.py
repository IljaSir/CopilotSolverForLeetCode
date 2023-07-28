class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        
        total = 0
        for i in range(len(brackets)):
            if i == len(brackets) - 1:
                total += (income - brackets[i][0]) * brackets[i][1] / 100
                break
            if income < brackets[i + 1][0]:
                total += (income - brackets[i][0]) * brackets[i][1] / 100
                break
            total += (brackets[i + 1][0] - brackets[i][0]) * brackets[i][1] / 100
        return total