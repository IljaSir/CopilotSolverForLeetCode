class Solution:
    def minSwaps(self, s: str) -> int:
        
        if len(s) % 2 == 1:
            return -1
        cnt0 = 0
        cnt1 = 0
        for i in range(len(s)):
            if i % 2 == 0:
                if s[i] == '0':
                    cnt0 += 1
                else:
                    cnt1 += 1
            else:
                if s[i] == '0':
                    cnt1 += 1
                else:
                    cnt0 += 1
        if cnt0 == cnt1:
            return cnt0 // 2
        elif cnt0 == cnt1 + 1:
            return cnt0 // 2
        elif cnt1 == cnt0 + 1:
            return cnt1 // 2
        else:
            return -1