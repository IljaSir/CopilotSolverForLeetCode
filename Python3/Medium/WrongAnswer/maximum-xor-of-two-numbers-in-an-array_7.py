class Solution:
    def findMaximumXOR(self, nums: List[int]) -> int:
        
        max_num = max(nums)
        mask = 0
        for i in range(31, -1, -1):
            mask = mask | (1 << i)
            prefix_set = set()
            for num in nums:
                prefix_set.add(num & mask)
            temp = max_num | (1 << i)
            for prefix in prefix_set:
                if temp ^ prefix in prefix_set:
                    max_num = temp
                    break
        return max_num