class Solution:
    def distributeCandies(self, candies: int, num_people: int) -> List[int]:
        
        i = 0
        result = [0] * num_people
        while candies > 0:
            result[i % num_people] += min(candies, i + 1)
            candies -= i + 1
            i += 1
        return result