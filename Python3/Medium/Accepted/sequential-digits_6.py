class Solution:
    def sequentialDigits(self, low: int, high: int) -> List[int]:
        
        ret = []
        for i in range(1, 9):
            num = 0
            for j in range(i, 10):
                num = num * 10 + j
                if low <= num <= high:
                    ret.append(num)
        return sorted(ret)