class Solution:
    def isPalindrome(self, s: str) -> bool:
        
        # This is a naive approach
        # The idea is to use the following 2 functions
        # 1. isalnum() - Returns True if all characters in the string are alphanumeric
        # 2. lower() - Converts all uppercase characters in a string into lowercase characters and returns it
        # 3. The idea is to use the above 2 functions to get a string that has only alphanumeric characters and is in lowercase
        # 4. Then we compare the original string with the reversed string to check if it is a palindrome
        # 5. We use the reversed() function to reverse the string
        # 6. Note that reversed() returns a reversed iterator, so we need to convert it into a string using the join() function
        # 7. We also need to use the list() function to convert the reversed iterator into a list
        # 8. We also need to use the lower() function to convert all uppercase characters into lowercase characters
        # 9. We also need to use the isalnum() function to check if all characters in the string are alphanumeric
        # 10. We also need to use the join() function to convert the list of characters into a string
        # 11. Note that the join() function only works on lists of strings
        # 12. So we need to use the map() function to convert all the characters in the string into a list of strings
        # 13. We also need to use the list() function to convert the map object into a list
        # 14. We also need to use the lower() function to convert all uppercase characters into lowercase characters
        # 15. We also need to use the isalnum() function to check if all characters in the string are alphanumeric
        # 16. We also need to use the join() function to convert the list of characters into a string
        # 17. Note that the join() function only works on lists of strings
        # 18. So we need to use the map() function to convert all the characters in the string into a list of strings
        # 19. We also need to use the list() function to convert the map object into a list
        # 20. We also need to use the lower() function to convert all uppercase characters into lowercase characters
        # 21. We also need to