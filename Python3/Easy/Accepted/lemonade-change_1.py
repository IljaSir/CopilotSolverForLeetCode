class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        
        cash = {5:0, 10:0, 20:0}
        for bill in bills:
            if bill == 5:
                cash[5] += 1
            elif bill == 10:
                if cash[5] > 0:
                    cash[5] -= 1
                    cash[10] += 1
                else:
                    return False
            elif bill == 20:
                if cash[10] > 0 and cash[5] > 0:
                    cash[10] -= 1
                    cash[5] -= 1
                    cash[20] += 1
                elif cash[5] > 2:
                    cash[5] -= 3
                    cash[20] += 1
                else:
                    return False
        return True