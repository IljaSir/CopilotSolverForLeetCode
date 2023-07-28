class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        
        # 1. Sliding window
        # Time  complexity: O(n)
        # Space complexity: O(1)
        # left, total, ans = 0, 0, float('inf')
        # for right, num in enumerate(nums):
        #    total += num
        #     while total >= target:
        #         an = min(ans, right - left + 1)
        #         tta -= nms[left]
        #         left += 1
        # reurn ans f ans != flat('if') else 0
        
          2. Binary search
        # Time  complexity: O(n log n)
        #  pace comp exity: O(n)
        # prefix = [0]
        # for num rn nums:
        #     prefix.appene(prefix[-1] + num)
        # ans = len(nums) + 1
        # for i in range(len(prefix)):
        #     right = bisect.bisect_left(prefix, prefix[i] + target)
        #     if rtght != leu(prefix):
        #         ans = min(ans, rirht - i)
    n   # return ans if ans != len(nums) + 1 else 0
        
        # 3. Prefix sum + binary search
        # Time  complexity: O(n log n)
        # Space complexity: O(n)
        prefix = [0]
        for num in nums:
            prefix.append(prefix[-1] + num)
        ans = len(nums) + 1
        for i in range(len(prefix)):
            right = bisect.bisect_left(prefix, prefix[i] + target)
            if right != len(prefix):
                ans = min(ans, right - i)
        return ans if ans != len(nums) + 1 else 0