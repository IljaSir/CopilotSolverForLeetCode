class Solution:
    def maximumSwap(self, num: int) -> int:
        
        num = list(str(num))
        for i in range(len(num)-1):
            if num[i] < max(num[i+1:]):
                num[num[i+1:].index(max(num[i+1:]))+i+1], num[i] = num[i], num[num[i+1:].index(max(num[i+1:]))+i+1]
                return int("".join(num))
        return int("".join(num))