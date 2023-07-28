class Solution:
    def canThreePartsEqualSum(self, arr: List[int]) -> bool:
        
        # 1. Initialize a variable sum and set it equal to the sum of all the elements in the array.
        sum = 0
        for i in arr:
            sum += i
        # 2. If the sum is not divisible by 3, then we cannot partition the array into three equal parts. Return false.
        if sum % 3 != 0:
            return False
        # 3. Initialize a variable part and set it equal to sum / 3. This is the sum of each part.
        part = sum / 3
        # 4. Initialize a variable curr_sum and set it equal to 0.
        curr_sum = 0
        # 5. Initialize a variable count and set it equal to 0.
        count = 0
        # 6. Iterate through the array.
        for i in arr:
            # 7. Add the current element to curr_sum.
            curr_sum += i
            # 8. If curr_sum is equal to part, then we have found a partition. Increment count by 1 and set curr_sum equal to 0.
            if curr_sum == part:
                count += 1
                curr_sum = 0
        # 9. Return true if count is equal to 3 and false otherwise.
        return count == 3