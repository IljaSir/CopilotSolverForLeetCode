class Solution:
    def maximumANDSum(self, nums: List[int], numSlots: int) -> int:
        
        # sort nums in descending order
        nums.sort(reverse=True)
        # initialize a list of numSlots zeros
        slots = [0] * numSlots
        # iterate through nums
        for num in nums:
            # iterate through slots
            for i in range(numSlots):
                # if num is greater than the slot
                if num > slots[i]:
                    # set the slot to num
                    slots[i] = num
                    # break
                    break
        # initialize a variable to 0
        ans = 0
        # iterate through slots
        for i in range(numSlots):
            # add the bitwise AND of the slot and i + 1 to ans
            ans += slots[i] & (i + 1)
        # return ans
        return ans