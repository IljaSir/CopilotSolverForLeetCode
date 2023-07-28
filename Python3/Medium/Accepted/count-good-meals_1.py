class Solution:
    def countPairs(self, deliciousness: List[int]) -> int:
        
        count = collections.Counter(deliciousness)
        ans = 0
        for x in count:
            for y in range(22):
                z = 2**y - x
                if z in count:
                    if z == x:
                        ans += count[x]*(count[x]-1)
                    else:
                        ans += count[x]*count[z]
        return ans // 2 % (10**9 + 7)