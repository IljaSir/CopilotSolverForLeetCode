class Solution:
    def decodeAtIndex(self, s: str, k: int) -> str:
        
        n = len(s)
        size = 0
        for i in range(n):
            if s[i].isdigit():
                size *= int(s[i])
            else:
                size += 1
            if size >= k:
                break
        for j in range(i, -1, -1):
            if s[j].isdigit():
                size /= int(s[j])
                k %= size
            else:
                if k == size or k == 0:
                    return s[j]
                size -= 1