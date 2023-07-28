class Solution:
    def splitNum(self, num: int) -> int:
        
        num1 = 0
        num2 = 0
        num1_list = []
        num2_list = []
        num_list = list(str(num))
        num_list.sort(reverse=True)
        for i in range(len(num_list)):
            if i % 2 == 0:
                num1_list.append(num_list[i])
            else:
                num2_list.append(num_list[i])
        num1 = int(''.join(num1_list))
        num2 = int(''.join(num2_list))
        return num1 + num2