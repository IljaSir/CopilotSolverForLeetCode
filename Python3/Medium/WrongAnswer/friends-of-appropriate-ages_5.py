class Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        
        from collections import Counter
        counter = Counter(ages)
        ans = 0
        for a, count_a in counter.items():
            for b, count_b in counter.items():
                if a * 0.5 + 7 < b <= a:
                    ans += count_a * count_b
                if a == b and count_a > 1:
                    ans += count_a * (count_a - 1)
        return ans