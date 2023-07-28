class Solution:
    def maximumSwap(self, num: int) -> int:
        
        num = list(str(num))
        for i in range(len(num)):
            max_num = max(num[i:])
            if max_num > num[i]:
                for j in range(len(num)-1, i, -1):
                    if num[j] == max_num:
                        num[i], num[j] = num[j], num[i]
                        return int("".join(num))
        return int("".join(num))