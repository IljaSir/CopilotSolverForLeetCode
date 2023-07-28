class Solution:
    def maximumCandies(self, candies: List[int], k: int) -> int:
        
        # the number of piles of candies
        n = len(candies)
        # the number of candies each child will get
        candies_per_child = k
        # the maximum number of candies each child can get
        max_candies_per_child = 0
        # the number of candies in each pile
        for i in range(n):
            # the number of candies in the pile
            candies_in_pile = candies[i]
            # the number of candies each child will get
            candies_per_child = k
            # the number of candies each child will get
            while candies_per_child > 0:
                # the number of candies each child will get
                if candies_in_pile >= candies_per_child:
                    # the maximum number of candies each child can get
                    max_candies_per_child += candies_per_child
                    # the number of candies in the pile
                    candies_in_pile -= candies_per_child
                    # the number of candies each child will get
                    candies_per_child = 0
                # the number of candies each child will get
                else:
                    # the maximum number of candies each child can get
                    max_candies_per_child += candies_in_pile
                    # the number of candies in the pile
                    candies_in_pile = 0
                    # the number of candies each child will get
                    candies_per_child -= candies_in_pile
                # the number of candies each child will get
                candies_per_child -= 1
        # the maximum number of candies each child can get
        return max_candies_per_child