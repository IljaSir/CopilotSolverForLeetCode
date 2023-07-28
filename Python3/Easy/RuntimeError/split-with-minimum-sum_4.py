class Solution:
    def splitNum(self, num: int) -> int:
        
        digits = list(str(num))
        digits.sort()
        digits = digits[::-1]
        print(digits)
        num1 = 0
        num2 = 0
        for i in range(len(digits)):
            if num1 <= num2:
                num1 = num1*10 + int(digits[i])
            else:
                num2 = num2*10 + int(digits[i]
                    answer += i * 10 + j
                    break
            break
        for i in range(1, 10):
            while count[i] > 0:
                answer += i
                count[i] -= 1
        return answer