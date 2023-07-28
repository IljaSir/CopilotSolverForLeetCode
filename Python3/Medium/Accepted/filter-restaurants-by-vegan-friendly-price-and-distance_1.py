class Solution:
    def filterRestaurants(self, restaurants: List[List[int]], veganFriendly: int, maxPrice: int, maxDistance: int) -> List[int]:
        
        return [r[0] for r in sorted(filter(lambda r: (r[2] >= veganFriendly) and (r[3] <= maxPrice) and (r[4] <= maxDistance), restaurants), key=lambda r: (r[1], r[0]), reverse=True)]