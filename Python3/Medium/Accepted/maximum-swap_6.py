class Solution:
    def maximumSwap(self, num: int) -> int:
        
        num = [int(c) for c in str(num)]
        for i in range(len(num)-1):
            m = max(num[i+1:])
            if m > num[i]:
                for j in range(len(num)-1, i, -1):
                    if num[j] == m:
                        num[i], num[j] = num[j], num[i]
                        return int(''.join(map(str, num)))
        return int(''.join(map(str, num)))