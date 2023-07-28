class Solution:
    def mostFrequent(self, nums: List[int], key: int) -> int:
        
        # First, find all the indices where the key occurs
        key_indices = [i for i, x in enumerate(nums) if x == key]
        # Then, find all the numbers that follow the key
        following_numbers = [nums[i+1] for i in key_indices if i < len(nums)-1]
        # Finally, find the most frequent number that follows the key
        return max(set(following_numbers), key=following_numbers.count)