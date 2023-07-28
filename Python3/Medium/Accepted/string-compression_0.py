class Solution:
    def compress(self, chars: List[str]) -> int:
        
        if len(chars) < 2:
            return len(chars)
        i = 0
        j = 0
        count = 1
        while j < len(chars):
            if j < len(chars) - 1 and chars[j] == chars[j + 1]:
                count += 1
            else:
                chars[i] = chars[j]
                i += 1
                if count > 1:
                    for c in str(count):
                        chars[i] = c
                        i += 1
                count = 1
            j += 1
        return i