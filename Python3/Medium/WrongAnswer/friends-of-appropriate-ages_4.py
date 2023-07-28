class Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        
        ages.sort()
        count = 0
        for i, age in enumerate(ages):
            if age >= 14:
                for j in range(i):
                    if ages[j] <= 0.5 * age + 7:
                        count += 1
                for j in range(i + 1, len(ages)):
                    if ages[j] <= 0.5 * age + 7:
                        count += 1
                    else:
                        break
        return count