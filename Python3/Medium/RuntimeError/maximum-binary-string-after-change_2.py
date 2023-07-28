class Solution:
    def maximumBinaryString(self, binary: str) -> str:
        
        # Solution 1 - 16 ms
        """
        # Count the number of 0s before the first 1
        # If there are no 1s, return binary
        # If there are 1s, we can swap all the 0s before the first 1 to 1s
        # We can also swap the last 1 to a 0
        # If there are more than 1 0s after the first 1, we can swap all the 0s after the first 1 to 1s
        """
        if "1" not in binary:
            return binary
        first_one = binary.index("1")
        num_zeroes = binary[:first_one].count("0")
        if num_zeroes == 0:
            return binary
        else:
            return "1" * (len(binary) - num_zeroes - 1) + "0" + "1" * num_zeroes
        # Solution 2 - 20 ms
        """
        # Count the number of 0s before the first 1
        # If there are no 1s, return binary
        # If there are 1s, we can swap all the 0s before the first 1 to 1s
        # We can also swap the last 1 to a 0
        # If there are more than 1 0s after the first 1, we can swap all the 0s after the first 1 to 1s
        """
        if "1" not in binary:
            return binary
        first_one = binary.index("1")
        num_zeroes = binary[:first_one].count("0")
        if num_zeroes == 0:
            return binary
        else:
            return "1" * (len(binary) - num_zeroes - 1) + "0" + "1" * num_zeroes
        # Solution 3 - 20 ms
        """
        # Count the number of 0s before the first 1
        # If there are no 1s, return binary
        # If there are 1s, we can swap all the 0s before the first 1 to 1s
        # We can also swap the last 1 to a 0
        # If there are more than 1 0