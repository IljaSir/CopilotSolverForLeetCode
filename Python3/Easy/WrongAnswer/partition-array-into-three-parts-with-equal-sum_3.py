class Solution:
    def canThreePartsEqualSum(self, arr: List[int]) -> bool:
        
        # 1st solution
        # Time  complexity: O(N)
        # Space complexity: O(1)
        # sum_arr = sum(arr)
        # if sum_arr % 3 != 0:
        #     return False
        # sum_arr //= 3
        # sum_ = 0
        # count = 0
        # for num in arr:
        #     sum_ += num
        #     if sum_ == sum_arr:
        #         sum_ = 0
        #         count += 1
        # return count == 3
        # 2nd solution
        # Time  complexity: O(N)
        # Space complexity: O(1)
        sum_arr = sum(arr)
        if sum_arr % 3 != 0:
            return False
        sum_arr //= 3
        sum_ = 0
        count = 0
        for num in arr:
            sum_ += num
            if sum_ == sum_arr:
                sum_ = 0
                count += 1
                if count == 2:
                    return True
        return False