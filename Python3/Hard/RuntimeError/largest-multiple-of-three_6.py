class Solution:
    def largestMultipleOfThree(self, digits: List[int]) -> str:
        
        d = [0]*10
        for x in digits:
            d[x] += 1
        s = sum(digits)
        if s%3 == 1:
            if d[1] > 0:
                d[1] -= 1
            elif d[4] > 0:
                d[4] -= 1
            elif d[7] > 0:
                d[7] -= 1
            elif d[2] > 1:
                d[2] -= 2
            elif d[5] > 1:
                d[5] -= 2
            elif d[8] > 1:
                d[8] -= 2
            elif d[2] > 0 and d[5] > 0:
                d[2] -= 1
                d[5] -= 1
            elif d[2] > 0 and d[8] > 0:
                d[2] -= 1
                d[8] -= 1
            elif d[5] > 0 and d[8] > 0:
                d[5] -= 1
                d[8] -= 1
            else:
                return ""
        elif s%3 == 2:
            if d[2] > 0:
                d[2] -= 1
            elif d[5] > 0:
                d[5] -= 1
            elif d[8] > 0:
                d[8] -= 1
            elif d[1] > 1:
                d[1] -= 2
            elif d[4] > 1:
                d[4] -= 2
            elif d[7] > 1:
                d[7] -= 2
            elif d[1] > 0 and d[4] > 0:
                d[1] -= 1
                d[4] -= 1
            elif d[1] > 0 and d[7] > 0:
                d[1] -= 1
                d[7] -= 1
            elif d[4] > 0 and d[7] > 0:
                d[4] -= 1
                d[7] -= 1
            else: