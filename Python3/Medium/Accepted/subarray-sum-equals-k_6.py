class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        
        # brute force: O(n^2) time
        # cum_sum = [0] * len(nums)
        # for i in range(len(nums)):
        #     cum_sum[i] = cum_sum[i-1] + nums[i]
        # count = 0
        # for i in range(len(nums)):
        #     for j in range(i, len(nums)):
        #         if cum_sum[j] - cum_sum[i-1] == k:
        #             count += 1
        # return count

        # O(n) time, O(n) space
        cum_sum = 0
        count = 0
        cum_sum_dict = {0:1}
        for i in range(len(nums)):
            cum_sum += nums[i]
            if cum_sum - k in cum_sum_dict:
                count += cum_sum_dict[cum_sum - k]
            if cum_sum in cum_sum_dict:
                cum_sum_dict[cum_sum] += 1
            else:
                cum_sum_dict[cum_sum] = 1
        return count