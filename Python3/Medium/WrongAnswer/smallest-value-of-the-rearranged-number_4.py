class Solution:
    def smallestNumber(self, num: int) -> int:
        
        if num == 0:
            return 0
        if num > 0:
            return int("".join(sorted(str(num))))
        else:
            return -int("".join(sorted(str(num)[1:])))