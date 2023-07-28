class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        
        # Time  complexity: O(N)
        # Space complexity: O(N)
        count = collections.Counter()
        count[0] = 1

        ans = su