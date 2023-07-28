class Solution:
    def countMaxOrSubsets(self, nums: List[int]) -> int:
        
        # 1. sort nums
        # 2. for each number, check if it is a subset of the previous number
        # 3. if it is, add it to the previous number
        # 4. if it is not, add it to the result
        # 5. return the result
        nums.sort()
        result = set()
        for num in nums:
            if not result:
                result.add(num)
            else:
                for previous_num in result.copy():
                    result.add(previous_num | num)
        return len(result)