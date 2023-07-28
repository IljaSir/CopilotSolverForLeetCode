class Solution:
    def compress(self, chars: List[str]) -> int:
        
        i = 0
        j = 0
        while j < len(chars):
            k = j
            while k < len(chars) and chars[k] == chars[j]:
                k += 1
            chars[i] = chars[j]
            i += 1
            if k - j > 1:
                for c in str(k - j):
                    chars[i] = c
                    i += 1
            j = k
        return i