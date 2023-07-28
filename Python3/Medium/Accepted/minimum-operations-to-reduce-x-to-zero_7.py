class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        
        # Solution 1: Binary Search
        # 1. Find the maximum subarray of length n such that sum(subarray) = total_sum - x
        # 2. Return len(nums) - n
        # 3. If not found, return -1
        # Time Complexity: O(nlogn)
        # Space Complexity: O(1)
        # n = len(nums)
        # total_sum = sum(nums)
        # target = total_sum - x
        # if target < 0:
        #     return -1
        # if target == 0:
        #     return n
        # max_length = -1
        # left = 0
        # current_sum = 0
        # for right in range(n):
        #     current_sum += nums[right]
        #     while current_sum > target:
        #         current_sum -= nums[left]
        #         left += 1
        #     if current_sum == target:
        #         max_length = max(max_length, right - left + 1)
        # return n - max_length if max_length != -1 else -1

        # Solution 2: Prefix Sum
        # 1. prefix_sum[i] = sum(nums[:i])
        # 2. Find the maximum subarray of length n such that prefix_sum[i] - prefix_sum[j] = x
        # 3. Return len(nums) - n
        # 4. If not found, return -1
        # Time Complexity: O(n)
        # Space Complexity: O(n)
        n = len(nums)
        prefix_sum = [0]
        for num in nums:
            prefix_sum.append(prefix_sum[-1] + num)
        target = prefix_sum[-1] - x
        if target < 0:
            return -1
        if target == 0:
            return n
        max_length = -1
        prefix_sum_dict = {}
        for i, prefix in enumerate(prefix_sum):
            if prefix - target in prefix_sum_dict:
                max_length = max(max_length, i - prefix_sum_dict[prefix - target])
            prefix_sum_dict[prefix] = i
        return n - max_length if max_length != -1 else -1