class Solution:
    def addDigits(self, num: int) -> int:
        
        # 1st solution
        # 36ms, 14.3MB
        # while num >= 10:
        #     num = sum(map(int, str(num)))
        # return num
        # 2nd solution
        # 28ms, 14.2MB
        if num == 0:
            return 0
        if num % 9 == 0:
            return 9
        return num % 9