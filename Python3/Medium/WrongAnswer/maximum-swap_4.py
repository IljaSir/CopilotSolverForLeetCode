class Solution:
    def maximumSwap(self, num: int) -> int:
        
        num = list(str(num))
        for i in range(len(num)):
            max_num = max(num[i:])
            if max_num != num[i]:
                max_index = num[i:].index(max_num) + i
                num[i], num[max_index] = num[max_index], num[i]
                break
        return int(''.join(num))