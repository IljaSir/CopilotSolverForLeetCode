class Solution:
    def countRangeSum(self, nums: List[int], lower: int, upper: int) -> int:
        
        sums = [0]
        for num in nums:
            sums.append(sums[-1] + num)
        return self.countWhileMergeSort(sums, 0, len(sums), lower, upper)