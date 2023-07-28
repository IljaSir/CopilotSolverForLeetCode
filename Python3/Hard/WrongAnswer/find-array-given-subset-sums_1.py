class Solution:
    def recoverArray(self, n: int, sums: List[int]) -> List[int]:
        
        # 1st approach
        # O(n^2) time
        # O(n) space
        # sort the sums
        sums.sort()
        # get the difference of each pair
        diffs = [sums[i] - sums[i-1] for i in range(1, len(sums))]
        # get the median of the differences
        median = diffs[len(diffs)//2]
        # get the answer
        ans = [sums[0] + median]
        for i in range(1, len(sums)):
            ans.append(sums[i] - ans[-1])
        return ans