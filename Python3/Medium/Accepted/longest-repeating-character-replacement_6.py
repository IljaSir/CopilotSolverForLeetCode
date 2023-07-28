class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        
        n = len(s)
        if n == 0:
            return 0

        # sliding window
        left, right = 0, 0
        # count the frequency of each character
        count = collections.Counter()
        # the length of the longest substring
        max_len = 1

        while right < n:
            # add the character at the right end of the window
            count[s[right]] += 1
            # get the most frequent character
            max_count = count.most_common(1)[0][1]
            # if the number of characters other than the most frequent character <= k, we can extend the window
            if right - left + 1 - max_count <= k:
                max_len = max(max_len, right - left + 1)
            else:
                count[s[left]] -= 1
                left += 1
            right += 1

        return max_len