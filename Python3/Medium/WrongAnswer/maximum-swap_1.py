class Solution:
    def maximumSwap(self, num: int) -> int:
        
        num = list(str(num))
        for i in range(len(num)):
            for j in range(i+1, len(num)):
                num[i], num[j] = num[j], num[i]
                if num > num[i:j+1]:
                    return int(''.join(num))
                num[i], num[j] = num[j], num[i]
        return int(''.join(num))