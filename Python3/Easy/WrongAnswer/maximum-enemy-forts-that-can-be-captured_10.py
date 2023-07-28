class Solution:
    def captureForts(self, forts: List[int]) -> int:
        
        n = len(forts)
        if n < 3:
            return 0
        if forts.count(1) == 0 or forts.count(0) == 0:
            return 0
        if forts.count(1) == 1:
            return forts.count(0)
        if forts.count(0) == 1:
            return 0
        ans = 0
        for i in range(n):
            if forts[i] == 1:
                j = i + 1
                while j < n and forts[j] == 0:
                    j += 1
                if j < n and forts[j] == 1:
                    ans += forts[i+1:j].count(0)
        return ans