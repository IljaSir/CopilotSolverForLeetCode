class Solution:
    def compress(self, chars: List[str]) -> int:
        
        if len(chars) == 1:
            return 1
        i = 0
        while i < len(chars):
            j = i
            while j < len(chars) and chars[i] == chars[j]:
                j += 1
            if j - i > 1:
                for c in str(j - i):
                    chars.insert(i + 1, c)
                    i += 1
            i += 1
        return len(chars)