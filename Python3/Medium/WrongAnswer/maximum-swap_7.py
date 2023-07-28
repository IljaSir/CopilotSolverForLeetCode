class Solution:
    def maximumSwap(self, num: int) -> int:
        
        s = list(str(num))
        for i in range(len(s)):
            max_num = max(s[i:])
            if max_num > s[i]:
                max_idx = s[i:].index(max_num) + i
                s[i], s[max_idx] = s[max_idx], s[i]
                break
        return int("".join(s))