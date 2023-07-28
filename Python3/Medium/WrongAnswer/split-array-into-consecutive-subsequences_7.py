class Solution:
    def isPossible(self, nums: List[int]) -> bool:
        
        # 1. count the number of each element
        # 2. for each element, check if it can be appended to a existing subsequence. if not, create a new subsequence
        # 3. if the number of the element is zero, skip it
        # 4. if the number of the element is not zero, check if it can be appended to a existing subsequence
        # 5. if it can be appended to a existing subsequence, append it and decrease the number of the element by one
        # 6. if it cannot be appended to a existing subsequence, check if the number of the element is larger than 1
        # 7. if the number of the element is larger than 1, create a new subsequence and decrease the number of the element by 3
        # 8. if the number of the element is not larger than 1, return False
        # 9. if the number of the element is zero, skip it
        # 10. if all the elements are checked, return True
        counter = collections.Counter(nums)
        for i in nums:
            if counter[i] == 0:
                continue
            if counter[i-1] > 0:
                counter[i] -= 1
                counter[i-1] -= 1
            elif counter[i+1] > 0 and counter[i+2] > 0:
                counter[i] -= 1
                counter[i+1] -= 1
                counter[i+2] -= 1
            else:
                return False
        return True