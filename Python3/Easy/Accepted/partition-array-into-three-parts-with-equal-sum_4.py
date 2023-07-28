class Solution:
    def canThreePartsEqualSum(self, arr: List[int]) -> bool:
        
        # Runtime: 384 ms, faster than 5.04% of Python3 online submissions for Partition Array Into Three Parts With Equal Sum.
        # Memory Usage: 15.6 MB, less than 5.04% of Python3 online submissions for Partition Array Into Three Parts With Equal Sum.
        # total = sum(arr)
        # if total % 3 != 0:
        #     return False
        # avg = total // 3
        # count = 0
        # temp_sum = 0
        # for i in range(len(arr)):
        #     temp_sum += arr[i]
        #     if temp_sum == avg:
        #         count += 1
        #         temp_sum = 0
        # return count == 3
        # Runtime: 332 ms, faster than 5.04% of Python3 online submissions for Partition Array Into Three Parts With Equal Sum.
        # Memory Usage: 15.6 MB, less than 5.04% of Python3 online submissions for Partition Array Into Three Parts With Equal Sum.
        total = sum(arr)
        if total % 3 != 0:
            return False
        avg = total // 3
        count = 0
        temp_sum = 0
        for i in range(len(arr)):
            temp_sum += arr[i]
            if temp_sum == avg:
                count += 1
                if count == 3:
                    return True
                temp_sum = 0
        return False