class Solution:
    def addDigits(self, num: int) -> int:
        
        # if num < 10:
        #     return num
        # else:
        #     num = str(num)
        #     num_list = list(num)
        #     num_list = [int(i) for i in num_list]
        #     num = sum(num_list)
        #     return self.addDigits(num)
        # return 1 + (num - 1) % 9 if num > 0 else 0
        while num > 9:
            num = sum([int(i) for i in str(num)])
        return num