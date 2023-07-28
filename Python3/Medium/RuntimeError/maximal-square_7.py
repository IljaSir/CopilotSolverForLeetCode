class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        # We can use the same approach as in rectangle-area.py
        # but we need to extend it for the case where the matrix
        # has 0's.
        # We will use the same approach as in product-of-array-except-self.py
        # to fill the table of areas.
        # Let's start with the 1st row and 1st column:
        # 1) If we have a 1 in the 1st row, then we can fill the 1st
        #    column with 1's.
        # 2) If we have a 1 in the 1st column, then we can fill the 1st
        #    row with 1's.
        # 3) If we have a 0 in the 1st row, then we can fill the 1st
        #    column with 0's.
        # 4) If we have a 0 in the 1st column, then we can fill the 1st
        #    row with 0's.
        # We can use the same approach for the rest of the matrix.
        # The only difference is that we need to use the minimum of the
        # three values: top, left, and top-left. We can use the same
        # approach as in different-ways-to-add-parentheses.py to find
        # the minimum of the three values.
        # We will use the same approach as in search-a-2d-matrix-ii.py
        # to find the maximum value in the table.
        # Let's start with the 1st row and 1st column:
        # 1) If we have a 1 in the 1st row, then we can fill the 1st
        #    column with 1's.
        # 2) If we have a 1 in the 1st column, then we can fill the 1st
        #    row with 1's.
        # 3) If we have a 0 in the 1st row, then we can fill the 1st
        #    column with 0's.
        # 4) If we have a 0 in the 1st column, then we can fill the 1st
        #    row with 0's.
        # We can use the