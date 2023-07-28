class Solution:
    def compress(self, chars: List[str]) -> int:
        
        i = 0
        while i < len(chars):
            c = chars[i]
            j = i + 1
            while j < len(chars) and chars[j] == c:
                j += 1
            if j - i > 1:
                for k, d in enumerate(str(j - i)):
                    chars[i + k + 1] = d
                del chars[i + k + 2:j]
            i = j
        return len(chars)