class Solution:
    def smallestNumber(self, num: int) -> int:
        
        # 1) Remove the sign
        # 2) Sort num
        # 3) If num[0] == 0, then move 0 to the end
        # 4) Add back the sign
        # 5) Return
        num = str(num)
        sign = ''
        if num[0] == '-':
            sign = '-'
            num = num[1:]
        num = sorted(num)
        if num[0] == '0':
            num.append(num.pop(0))
        return int(sign + ''.join(num))