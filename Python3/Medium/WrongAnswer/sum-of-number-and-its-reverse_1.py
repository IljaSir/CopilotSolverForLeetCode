class Solution:
    def sumOfNumberAndReverse(self, num: int) -> bool:
        
        num = str(num)
        for i in range(len(num)):
            num = num[1:] + num[0]
            if int(num) + int(num[::-1]) == int(num):
                return True
        return False