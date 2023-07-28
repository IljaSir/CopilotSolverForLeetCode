class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        
        tax = 0
        for i in range(len(brackets)):
            if income > brackets[i][0]:
                tax += brackets[i][0] * brackets[i][1] / 100
                income -= brackets[i][0]
            else:
                tax += income * brackets[i][1] / 100
                return tax
        return tax