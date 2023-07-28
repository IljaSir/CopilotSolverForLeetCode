class Solution:
    def compress(self, chars: List[str]) -> int:
        
        n = len(chars)
        if n == 1:
            return 1
        i, j = 0, 1
        while i < n and j < n:
            if chars[i] != chars[j]:
                i += 1
                j += 1
            else:
                k = j
                while k < n and chars[k] == chars[i]:
                    k += 1
                if k - j > 1:
                    chars[i+1:k] = str(k-j)
                    n -= k - j - 1
                    i += 2
                    j = i + 1
                else:
                    i += 1
                    j += 1
        return n