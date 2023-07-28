class Solution:
    def frequencySort(self, nums: List[int]) -> List[int]:
        
        # Get the frequency of each number
        freq = collections.Counter(nums)
        # Sort the numbers by frequency
        sorted_nums = sorted(nums, key=lambda x: (freq[x], -x))
        return sorted_nums