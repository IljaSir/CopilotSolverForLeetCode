class Solution:
    def compress(self, chars: List[str]) -> int:
        
        if len(chars) == 1:
            return 1
        i = 0
        j = 0
        while i < len(chars):
            count = 1
            while j < len(chars) - 1 and chars[j] == chars[j + 1]:
                j += 1
                count += 1
            if count > 1:
                for c in str(count):
                    chars.insert(i + 1, c)
                    i += 1
                    j += 1
            i += 1
            j += 1
        return len(chars)