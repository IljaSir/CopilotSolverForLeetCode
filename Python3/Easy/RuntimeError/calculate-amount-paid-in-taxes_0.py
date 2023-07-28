class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        
        # The first upper0 dollars earned are taxed at a rate of percent0.
        # The next upper1 - upper0 dollars earned are taxed at a rate of percent1.
        # The next upper2 - upper1 dollars earned are taxed at a rate of percent2.
        # And so on.
        # 1 <= brackets.length <= 100
        # 1 <= upperi <= 1000
        # 0 <= percenti <= 100
        # 0 <= income <= 1000
        # upperi is sorted in ascending order.
        # All the values of upperi are unique.
        # The upper bound of the last tax bracket is greater than or equal to income.
        # brackets = [[3,50],[7,10],[12,25]], income = 10
        # brackets = [[1,0],[4,25],[5,50]], income = 2
        # brackets = [[2,50]], income = 0
        # brackets = [[5,50],[10,10],[15,15]], income = 15
        # brackets = [[5,50],[10,10],[15,15]], income = 20
        # brackets = [[5,50],[10,10],[15,15]], income = 25
        # brackets = [[5,50],[10,10],[15,15]], income = 30
        # brackets = [[5,50],[10,10],[15,15]], income = 35
        # brackets = [[5,50],[10,10],[15,15]], income = 40
        # brackets = [[5,50],[10,10],[15,15]], income = 45
        # brackets = [[5,50],[10,10],[15,15]], income = 50
        # brackets = [[5,50],[10,10],[15,15]], income = 55
        # brackets = [[5,50],[10,10],[15,15]], income = 60
        # brackets = [[5,50],[10,10],[15,15]], income = 65
        # brackets = [[5,50],[10,10],[15,15]], income = 70
        # brackets = [[5,50],[10,10],[15,15]], income = 75
        # brackets = [[5,50