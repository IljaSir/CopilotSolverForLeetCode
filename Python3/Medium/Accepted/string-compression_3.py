class Solution:
    def compress(self, chars: List[str]) -> int:
        
        i = 0
        j = 0
        while i < len(chars):
            c = chars[i]
            count = 0
            while i < len(chars) and chars[i] == c:
                count += 1
                i += 1
            chars[j] = c
            j += 1
            if count > 1:
                for ch in str(count):
                    chars[j] = ch
                    j += 1
        return j