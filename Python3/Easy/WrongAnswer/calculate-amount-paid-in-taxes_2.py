class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        
        total = 0
        for i in range(len(brackets)):
            if income >= brackets[i][0]:
                total += brackets[i][0] * brackets[i][1] / 100
                income -= brackets[i][0]
            else:
                total += income * brackets[i][1] / 100
                break
        return total