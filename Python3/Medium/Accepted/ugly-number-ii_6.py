class Solution:
    def nthUglyNumber(self, n: int) -> int:
        
        ugly = [1]
        p2, p3, p5 = 0, 0, 0
        for i in range(1, n):
            ugly.append(min(ugly[p2]*2, ugly[p3]*3, ugly[p5]*5))
            if ugly[i] == ugly[p2]*2:
                p2 += 1
            if ugly[i] == ugly[p3]*3:
                p3 += 1
            if ugly[i] == ugly[p5]*5:
                p5 += 1
        return ugly[-1]