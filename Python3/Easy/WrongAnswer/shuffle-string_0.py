class Solution:
    def restoreString(self, s: str, indices: List[int]) -> str:
        s = list(s)
        for i in range(len(s)):
            s[indices[i]] = s[i]
        return "".join(s)