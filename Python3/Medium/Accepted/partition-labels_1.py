class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        
        end = {}
        for i, c in enumerate(s):
            end[c] = i
        start, ans = 0, []
        while start < len(s):
            last = end[s[start]]
            i = start
            while i < last:
                last = max(last, end[s[i]])
                i += 1
            ans.append(last - start + 1)
            start = last + 1
        return ans