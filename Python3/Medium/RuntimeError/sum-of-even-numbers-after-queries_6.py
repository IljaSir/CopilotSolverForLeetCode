class Solution:
    def sumEvenAfterQueries(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        
        # nums = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
        # Output: [8,6,2,4]
        # Explanation: At the beginning, the array is [1,2,3,4].
        # After adding 1 to nums[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
        # After adding -3 to nums[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
        # After adding -4 to nums[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
        # After adding 2 to nums[3], the array is [-2,-1,3,6], and the sum of even values