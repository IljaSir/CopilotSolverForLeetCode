class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        
        # # Soln 1 - Brute force
        # max_avg = -float('inf')
        # for i in range(len(nums) - k + 1):
        #     max_avg = max(max_avg, sum(nums[i:i+k]) / k)
        # return max_avg

        # # Soln 2 - Sliding window
        # max_sum = sum(nums[:k])
        # curr_sum = max_sum
        # for i in range(k, len(nums)):
        #     curr_sum += nums[i] - nums[i-k]
        #     max_sum = max(max_sum, curr_sum)
        # return max_sum / k

        # Soln 3 - Prefix sum
        prefix_sum = [0]
        for n in nums:
            prefix_sum.append(prefix_sum[-1] + n)
        max_avg = -float('inf')
        for i in range(k, len(prefix_sum)):
            max_avg = max(max_avg, (prefix_sum[i] - prefix_sum[i-k]) / k)
        return max_avg