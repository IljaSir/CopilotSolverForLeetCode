class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        
        # Time  complexity: O(N)
        # Space complexity: O(N)
        #         seen = set()
        #         for i, num in enumerate(nums):
        #             if num in seen:
        #                 return True
        #             seen.add(num)
        #             if len(seen) > k:
        #                 seen.remove(nums[i - k])
        #         return False
        # Time  complexity: O(N)
        # Space complexity: O(min(N, k))
        seen = {}
        for i, num in enumerate(nums):
            if num in seen and i - seen[num] <= k:
                return True
            seen[num] = i
        return False