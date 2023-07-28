class Solution:
    def checkZeroOnes(self, s: str) -> bool:
        
        prev = s[0]
        prev_count = 1
        max_count = 1
        for i in range(1, len(s)):
            if s[i] == prev:
                prev_count += 1
            else:
                max_count = max(max_count, prev_count)
                prev = s[i]
                prev_count = 1
        max_count = max(max_count, prev_count)
        prev = s[0]
        prev_count = 1
        min_count = 1
        for i in range(1, len(s)):
            if s[i] == prev:
                prev_count += 1
            else:
                min_count = min(min_count, prev_count)
                prev = s[i]
                prev_count = 1
        min_count = min(min_count, prev_count)
        return max_count > min_count