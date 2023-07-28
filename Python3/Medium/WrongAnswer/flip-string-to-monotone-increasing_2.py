class Solution:
    def minFlipsMonoIncr(self, s: str) -> int:
        
        """
        1. count number of 1's
        2. count number of 0's
        3. flip 0's to 1's
        4. flip 1's to 0's
        """
        # 1. count number of 1's
        num_ones = s.count("1")
        # 2. count number of 0's
        num_zeros = s.count("0")
        # 3. flip 0's to 1's
        flip_0_to_1 = 0
        # 4. flip 1's to 0's
        flip_1_to_0 = num_ones
        min_flips = float("inf")
        for char in s:
            if char == "0":
                flip_0_to_1 += 1
            else:
                flip_1_to_0 -= 1
            min_flips = min(min_flips, flip_0_to_1, flip_1_to_0)
        return min_flips