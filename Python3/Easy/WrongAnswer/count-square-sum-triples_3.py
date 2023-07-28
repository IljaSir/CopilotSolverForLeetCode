class Solution:
    def countTriples(self, n: int) -> int:
        
        # Solution 1: brute force
        # count = 0
        # for a in range(1, n+1):
        #     for b in range(1, n+1):
        #         for c in range(1, n+1):
        #             if a**2 + b**2 == c**2:
        #                 count += 1
        # return count

        # Solution 2: math
        count = 0
        for a in range(1, n+1):
            for b in range(1, n+1):
                c = math.sqrt(a**2 + b**2)
                if c.is_integer() and c <= n:
                    count += 2
        return count