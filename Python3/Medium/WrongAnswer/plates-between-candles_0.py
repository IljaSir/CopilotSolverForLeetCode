class Solution:
    def platesBetweenCandles(self, s: str, queries: List[List[int]]) -> List[int]:
        
        s = "||" + s + "||"
        n = len(s)
        ans = []
        for left, right in queries:
            left += 2
            right += 2
            count = 0
            for i in range(left, right + 1):
                if s[i] == "*":
                    if s[i-1] == "|" and s[i+1] == "|":
                        count += 1
            ans.append(count)
        return ans