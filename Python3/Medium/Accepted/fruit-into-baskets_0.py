class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        
        res, i, count = 0, 0, collections.Counter()
        for j, v in enumerate(fruits):
            count[v] += 1
            while len(count) > 2:
                count[fruits[i]] -= 1
                if count[fruits[i]] == 0:
                    del count[fruits[i]]
                i += 1
            res = max(res, j - i + 1)
        return res