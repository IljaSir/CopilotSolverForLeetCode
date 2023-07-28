class Solution:
    def candy(self, ratings: List[int]) -> int:
        
        # n = len(ratings)
        # if n == 0:
        #     return 0
        # if n == 1:
        #     return 1
        # if n == 2:
        #     return 3 if ratings[0] == ratings[1] else 4
        # res = 0
        # if ratings[0] < ratings[1]:
        #     res = 2
        #     prev = 2
        #     for i in range(2, n):
        #         if ratings[i] > ratings[i-1]:
        #             prev += 1
        #         else:
        #             prev = 1
        #         res += prev
        #     return res
        # else:
        #     res = 1
        #     prev = 1
        #     for i in range(2, n):
        #         if ratings[i] > ratings[i-1]:
        #             prev += 1
        #         else:
        #             prev = 1
        #         res += prev
        #     return res
        n = len(ratings)
        if n == 0:
            return 0
        if n == 1:
            return 1
        if n == 2:
            return 3 if ratings[0] == ratings[1] else 4
        res = 0
        if ratings[0] < ratings[1]:
            res = 2
            prev = 2
            for i in range(2, n):
                if ratings[i] > ratings[i-1]:
                    prev += 1
                else:
                    prev = 1
                res += prev
            return res
        else:
            res = 1
            prev = 1
            for i in range(2, n):
                if ratings[i] > ratings[i-1]:
                    prev += 1
                else:
                    prev = 1
                res += prev
            return res