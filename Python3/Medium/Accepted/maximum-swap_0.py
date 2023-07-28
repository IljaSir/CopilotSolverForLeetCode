class Solution:
    def maximumSwap(self, num: int) -> int:
        
        num_s = str(num)
        max_num = num
        for i in range(len(num_s)):
            for j in range(i + 1, len(num_s)):
                num_s = list(num_s)
                num_s[i], num_s[j] = num_s[j], num_s[i]
                num_s = "".join(num_s)
                max_num = max(max_num, int(num_s))
                num_s = str(num)
        return max_num