class Solution:
    def maximumSwap(self, num: int) -> int:
        
        num = list(str(num))
        for i in range(len(num)):
            max_val = max(num[i:])
            if max_val > num[i]:
                max_idx = num[i:].index(max_val) + i
                num[i], num[max_idx] = num[max_idx], num[i]
                break
        return int(''.join(num))