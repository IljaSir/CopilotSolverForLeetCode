class Solution:
    def isSameAfterReversals(self, num: int) -> bool:
        
        if num == 0:
            return True
        num_str = str(num)
        num_str_reversed = num_str[::-1]
        num_reversed = int(num_str_reversed)
        num_reversed_reversed = int(str(num_reversed)[::-1])
        return num_reversed_reversed == num