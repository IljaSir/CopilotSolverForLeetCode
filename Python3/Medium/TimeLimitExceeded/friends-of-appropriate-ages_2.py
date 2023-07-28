class Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        
        count = 0
        for i, age in enumerate(ages):
            for j, other_age in enumerate(ages):
                if i == j:
                    continue
                if 0.5 * age + 7 < other_age <= age:
                    count += 1
        return count