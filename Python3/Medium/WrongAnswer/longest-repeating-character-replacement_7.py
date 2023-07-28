class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        
        # sliding window
        # 窗口内的字符个数 - 窗口内出现次数最多的字符个数 + k >= 窗口长度
        # 满足条件则窗口右移，不满足条件则窗口左移
        d = {}
        i, j = 0, 0
        res = 0
        while j < len(s):
            if s[j] not in d:
                d[s[j]] = 1
            else:
                d[s[j]] += 1
            if j - i + 1 - max(d.values()) <= k:
                res = max(res, j - i + 1)
                j += 1
            else:
                d[s[i]] -= 1
                i += 1
        return res