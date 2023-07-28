class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        
        # sliding window
        # use a dict to keep track of the window
        # if the length of the dict is greater than k, we need to shrink the window
        # we can determine the length of the window by the max value in the dict
        # we can determine the length of the window by the max value in the dict
        # the max valu