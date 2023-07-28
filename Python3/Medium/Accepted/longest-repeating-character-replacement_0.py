class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        
        if not s:
            return 0
        cnt = collections.Counter()
        max_cnt = 0
        left = 0
        for right in range(len(s)):
            cnt[s[right]] += 1
            max_cnt = max(max_cnt, cnt[s[right]])
            if right - left + 1 - max_cnt > k:
                cnt[s[left]] -= 1
                left += 1
        return right - left + 1