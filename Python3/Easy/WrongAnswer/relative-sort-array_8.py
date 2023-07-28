class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        
        # Sort arr1
        arr1.sort()
        # Sort arr2
        arr2.sort()
        # Create a map to store the number of times each element appears in arr1
        arr1_map = {}
        # Iterate through arr1
        for num in arr1:
            # If the number is in arr1_map
            if num in arr1_map:
                # Increment the value of the number in arr1_map
                arr1_map[num] += 1
            # Else
            else:
                # Set the value of the number in arr1_map to 1
                arr1_map[num] = 1
        # Create a list to store the sorted numbers
        sorted_list = []
        # Iterate through arr2
        for num in arr2:
            # If the number is in arr1_map
            if num in arr1_map:
                # Iterate through the number of times the number appears in arr1
                for i in range(arr1_map[num]):
                    # Append the number to sorted_list
                    sorted_list.append(num)
                # Remove the number from arr1_map
                del arr1_map[num]
        # Iterate through the keys in arr1_map
        for num in arr1_map.keys():
            # Iterate through the number of times the number appears in arr1
            for i in range(arr1_map[num]):
                # Append the number to sorted_list
                sorted_list.append(num)
        # Return the sorted list
        return sorted_list