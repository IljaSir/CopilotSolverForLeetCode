class Solution:
    def minKBitFlips(self, nums: List[int], k: int) -> int:
        
        n = len(nums)
        flipped = [0] * (n + 1)
        count = 0
        for i in range(n):
            if i >= k:
                flipped[i] += flipped[i - k]
            if (nums[i] + flipped[i]) % 2 == 0:
                if i + k > n:
                    return -1
                flipped[i] += 1
                flipped[i + k] -= 1
                count += 1
        return count