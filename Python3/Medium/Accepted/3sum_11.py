class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        
        # Sort the array
        nums.sort()
        # Create a list to store the triplets
        triplets = []
        # Iterate through the array
        for i in range(len(nums)):
            # Skip if the current number is the same as the previous one
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            # Create two pointers for the left and right
            left = i + 1
            right = len(nums) - 1
            # Iterate through the array
            while left < right:
                # Calculate the sum of the current triplet
                current_sum = nums[i] + nums[left] + nums[right]
                # If the sum is 0, add the triplet to the list
                if current_sum == 0:
                    triplets.append([nums[i], nums[left], nums[right]])
                    # Move the left and right pointers
                    left += 1
                    right -= 1
                    # Skip if the left number is the same as the previous one
                    while left < right and nums[left] == nums[left - 1]:
                        left += 1
                    # Skip if the right number is the same as the previous one
                    while left < right and nums[right] == nums[right + 1]:
                        right -= 1
                # If the sum is greater than 0, move the right pointer to the left
                elif current_sum > 0:
                    right -= 1
                # If the sum is less than 0, move the left pointer to the right
                else:
                    left += 1
        # Return the list of triplets
        return triplets