class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        
        if len(nums) == 1:
            return [nums]
        else:
            all_permutations = []
            for i in range(len(nums)):
                permutations = self.permute(nums[:i] + nums[i+1:])
                for permutation in permutations:
                    all_permutations.append([nums[i]] + permutation)
            return all_permutations