class Solution:
    def smallestNumber(self, num: int) -> int:
        
        # Solution 1 - 32 ms
        """
        if num == 0:
            return 0
        if num < 0:
            return -int("".join(sorted(str(num)[:0:-1])))
        return int("".join(sorted(str(num))))
        """
        # Solution 2 - 20 ms
        if num == 0:
            return 0
        if num < 0:
            return -int("".join(sorted(str(num)[:0:-1])))
        return int("".join(sorted(str(num))))