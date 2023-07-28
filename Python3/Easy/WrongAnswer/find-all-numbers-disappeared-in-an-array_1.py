class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        # 1. Sort the array
        # 2. Iterate through the array, and add numbers to a set
        # 3. Iterate through the set, and add the missing numbers to a list
        # 4. Return the list
        # sort the array
        nums.sort()
        # create a set
        my_set = set()
        # iterate through the array
        for num in nums:
            # add each number to the set
            my_set.add(num)
        # create a list
        my_list = []
        # iterate through the set
        for num in my_set:
            # add each number to the list
            my_list.append(num)
        # return the list
        return my_list