class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        
        if len(fruits) == 1:
            return 1
        if len(fruits) == 2:
            return 2
        if len(fruits) == 3:
            if fruits[0] == fruits[1] or fruits[1] == fruits[2] or fruits[0] == fruits[2]:
                return 3
            else:
                return 2
        n = len(fruits)
        d = {}
        l = 0
        r = 0
        max_len = 0
        while r < n:
            if fruits[r] not in d:
                d[fruits[r]] = 1
            else:
                d[fruits[r]] += 1
            while len(d) > 2:
                d[fruits[l]] -= 1
                if d[fruits[l]] == 0:
                    del d[fruits[l]]
                l += 1
            max_len = max(max_len, r - l + 1)
            r += 1
        return max_len