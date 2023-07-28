class Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        
        cnt = collections.Counter(ages)
        ans = 0
        for ageA, countA in cnt.items():
            for ageB, countB in cnt.items():
                if ageB <= 0.5 * ageA + 7:
                    continue
                if ageB > ageA:
                    continue
                if ageB > 100 and ageA < 100:
                    continue
                ans += countA * countB
                if ageA == ageB:
                    ans -= countA
        return ans