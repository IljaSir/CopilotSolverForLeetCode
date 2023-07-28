class Solution:
    def smallestNumber(self, pattern: str) -> str:
        
        digits = [str(i) for i in range(1, len(pattern) + 2)]
        res = []
        i = 0
        while i < len(pattern):
            if pattern[i] == 'I':
                res.append(digits.pop(0))
            else:
                j = i
                while j < len(pattern) and pattern[j] == 'D':
                    j += 1
                res.extend(digits[len(pattern) - j - 1:len(pattern) - i])
                res.append(digits.pop(0))
                i = j
            i += 1
        res.append(digits.pop(0))
        return ''.join(res)