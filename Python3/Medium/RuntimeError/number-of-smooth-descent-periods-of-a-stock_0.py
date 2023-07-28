class Solution:
    def getDescentPeriods(self, prices: List[int]) -> int:
        
        # A smooth descent period of a stock consists of one or more contiguous days such that the price on each day is lower than the price on the preceding day by exactly 1. The first day of the period is exempted from this rule.
        # Return the number of smooth descent periods.
        # prices = [3,2,1,4]
        # prices = [8,6,7,7]
        # prices = [1]
        # prices = [3,3,3,3]
        # prices = [5,5,5,5]
        # prices = [1,2,3]
        # prices = [3,2,1]
        # prices = [1,2,3,4]
        # prices = [3,2,1,4]
        # prices = [1,2,3,4,3,2,1]
        # prices = [1,2,3,4,3,2,1,4]
        # prices = [1,2,3,4,3,2,1,4,3]
        # prices = [1,2,3,4,3,2,1,4,3,2]
        # prices = [1,2,3,4,3,2,1,4,3,2,1]
        # prices = [1,2,3,4,3,2,1,4,3,2,1,4]
        # prices = [1,2,3,4,3,2,1,4,3,2,1,4,3]
        # prices = [1,2,3,4,3,2,1,4,3,2,1,4,3,2]
        # prices = [1,2,3,4,3,2,1,4,3,2,1,4,3,2,1]
        # prices = [1,2,3,4,3,2,1,4,3,2,1,4,3,2,1,4]
        # prices = [1,2,3,4,3,2,1,4,3,2,1,4,3,2,1,4,3]
        # prices = [1,2,3,4,