class Solution:
    def maximumTop(self, nums: List[int], k: int) -> int:
        
        # 1. find the max number in nums
        # 2. find the number of max number in nums
        # 3. if k < number of max number in nums, return max number in nums
        # 4. if k >= number of max number in nums, return max number in nums - (k - number of max number in nums)
        max_num = max(nums)
        num_of_max_num = nums.count(max_num)
        if k < num_of_max_num:
            return max_num
        else:
            return max_num - (k - num_of_max_num)