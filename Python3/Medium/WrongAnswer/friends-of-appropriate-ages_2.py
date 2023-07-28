class Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        
        ages.sort()
        count = 0
        for i in range(len(ages)):
            for j in range(i+1, len(ages)):
                if ages[j] <= 0.5 * ages[i] + 7 or ages[j] > ages[i] or ages[j] > 100 and ages[i] < 100:
                    break
                else:
                    count += 2
        return count