class Solution:
    def compress(self, chars: List[str]) -> int:
        
        i = 0
        while i < len(chars):
            c = chars[i]
            j = i + 1
            while j < len(chars) and chars[j] == c:
                j += 1
            if j - i > 1:
                l = str(j - i)
                chars[i + 1:i + 1] = l
                i += len(l) + 1
            else:
                i += 1
        return len(chars)