class Solution:
    def maximumSum(self, arr: List[int]) -> int:
        
        # 1. If all elements are negative, return the max of them
        # 2. If all elements are positive, return the sum of them
        # 3. If there is a negative element, we have two choices:
        #   a. Remove the negative element
        #   b. Remove the element on the left of the negative element
        #   c. Remove the element on the right of the negative element
        # 4. If there are multiple negative elements, we have three choices:
        #   a. Remove the negative element
        #   b. Remove the element on the left of the negative element
        #   c. Remove the element on the right of the negative element
        #   d. Remove the negative element and the element on the left of the negative element
        #   e. Remove the negative element and the element on the right of the negative element
        # 5. If there are multiple negative elements, we can remove the negative element and the element on the left of the negative element, and then remove the negative element and the element on the right of the negative element. Then, we can compare the sum of the two subarrays.
        # 6. If there are multiple negative elements, we can remove the negative element and the element on the right of the negative element, and then remove the negative element and the element on the left of the negative element. Then, we can compare the sum of the two subarrays.
        # 7. If there are multiple negative elements, we can remove the negative element and the element on the left of the negative element, and then remove the negative element and the element on the left of the negative element. Then, we can compare the sum of the two subarrays.
        # 8. If there are multiple negative elements, we can remove the negative element and the element on the right of the negative element, and then remove the negative element and the element on the right of the negative element. Then, we can compare the sum of the two subarrays.
        # 9. If there are multiple negative elements, we can remove the negative element and the element on the left of the negative element, and then remove the negative element and the element on the right of the negative element. Then, we can compare the sum of the two subarrays.
        # 10. If there are multiple negative elements,