class Solution:
    def filterRestaurants(self, restaurants: List[List[int]], veganFriendly: int, maxPrice: int, maxDistance: int) -> List[int]:
        
        if veganFriendly == 1:
            restaurants = [r for r in restaurants if r[2] == 1]
        restaurants = [r for r in restaurants if r[3] <= maxPrice and r[4] <= maxDistance]
        return [r[0] for r in sorted(restaurants, key=lambda x: (x[1], x[0]), reverse=True)]