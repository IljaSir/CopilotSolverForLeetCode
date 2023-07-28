class Solution:
    def maximumSwap(self, num: int) -> int:
        
        num = list(str(num))
        for i in range(len(num)):
            for j in range(i+1, len(num)):
                if num[i] < num[j]:
                    num[i], num[j] = num[j], num[i]
                    return int("".join(num))
        return int("".join(num))