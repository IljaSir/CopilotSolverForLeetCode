class Solution:
    def compress(self, chars: List[str]) -> int:
        
        i, j = 0, 0
        while i < len(chars):
            c = chars[i]
            while j < len(chars) and chars[j] == c:
                j += 1
            if j - i > 1:
                for k in str(j - i):
                    chars[i + 1] = k
                    i += 1
            i += 1
        return i