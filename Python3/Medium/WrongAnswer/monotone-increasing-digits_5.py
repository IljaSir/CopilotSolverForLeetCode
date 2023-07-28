class Solution:
    def monotoneIncreasingDigits(self, n: int) -> int:
        
        # 1. Find the first non-increasing digit from the left
        # 2. Decrease the digit by 1, and set all the digits after it to 9
        # 3. Repeat 1 and 2 until the number is monotone increasing
        num = str(n)
        for i in range(len(num)-1):
            if num[i] > num[i+1]:
                num = num[:i] + str(int(num[i])-1) + '9'*(len(num)-i-1)
                break
        return int(num)