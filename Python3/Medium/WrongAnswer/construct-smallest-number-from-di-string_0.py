class Solution:
    def smallestNumber(self, pattern: str) -> str:
        
        n = len(pattern)
        nums = list(range(1, n + 2))
        res = []
        i = 0
        while i < n:
            j = i
            while j < n and pattern[j] == 'I':
                j += 1
            res.extend(nums[i:j + 1][::-1])
            i = j + 1
        return ''.join(map(str, res))