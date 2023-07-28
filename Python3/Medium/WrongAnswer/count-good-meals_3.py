class Solution:
    def countPairs(self, deliciousness: List[int]) -> int:
        
        mod = 10**9 + 7
        count = 0
        deliciousness.sort()
        for i, x in enumerate(deliciousness):
            for j in range(22):
                y = 2**j
                if y-x < x:
                    break
                if y-x == x:
                    count += bisect.bisect_right(deliciousness, y-x, i+1) - (i+1)
                else:
                    count += bisect.bisect_right(deliciousness, y-x) - bisect.bisect_right(deliciousness, x)
        return count % mod