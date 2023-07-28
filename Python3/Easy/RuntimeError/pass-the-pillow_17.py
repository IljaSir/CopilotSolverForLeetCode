class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        
        # First, we need to figure out how many times the pillow will go back and forth
        # between the ends of the line. If n is even, then the pillow will go back and
        # forth an even number of times. If n is odd, then the pillow will go back and
        # forth an odd number of times.
        # For example, if n is 4, then the pillow will go back and forth 2 times.
        # If n is 5, then the pillow will go back and forth 2 times.
        # If n is 6, then the pillow will go back and forth 3 times.
        # If n is 7, then the pillow will go back and forth 3 times.
        # If n is 8, then the pillow will go back and forth 4 times.
        # If n is 9, then the pillow will go back and forth 4 times.
        # So, if n is even, we divide it by 2. If n is odd, we divide it by 2 and then
        # add 1.
        # Then, we multiply that number by 2.
        # For example, if n is 4, then 4 // 2 is 2. 2 * 2 is 4.
        # If n is 5, then 5 // 2 is 2. 2 + 1 is 3. 3 * 2 is 6.
        # If n is 6, then 6 // 2 is 3. 3 * 2 is 6.
        # If n is 7, then 7 // 2 is 3. 3 + 1 is 4. 4 * 2 is 8.
        # If n is 8, then 8 // 2 is 4. 4 * 2 is 8.
        # If n is 9, then 9 // 2 is 4. 4 + 1 is 5. 5 * 2 is 10.
        # So, we can see that if n is even, then the pillow will go back and forth an
        # even number of times. If n is odd, then the pillow will go back and forth an
        # odd number of times.
        # Then, we subtract the number of times the