class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        
        max_len = 0
        sum = 0
        dict = {}
        for i in range(len(nums)):
            if nums[i] == 0:
                sum -= 1
            else:
                sum += 1
            if sum == 0:
                max_len = i + 1
            else:
                if sum in dict:
                    max_len = max(max_len, i - dict[sum])
                else:
                    dict[sum] = i
        return max_len