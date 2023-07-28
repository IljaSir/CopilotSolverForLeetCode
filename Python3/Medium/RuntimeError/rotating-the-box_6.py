class Solution:
    def rotateTheBox(self, box: List[List[str]]) -> List[List[str]]:
        
        # If the box is empty, return empty
        if len(box) == 0:
            return []
        # If the box is a single column, return the box
        if len(box[0]) == 1:
            return box
        # If the box is a single row, return the box
        if len(box) == 1:
            return box
        # Initialize a list of lists to hold the rotated box
        rotated_box = []
        # Iterate over the box from bottom to top
        for row in range(len(box) - 1, -1, -1):
            # Initialize a list to hold the row
            row_list = []
            # Iterate over the box from right to left
            for column in range(len(box[row]) - 1, -1, -1):
                # If the current box is a stone
                if box[row][column] == '#':
                    # Add a stone to the row list
                    row_list.append('#')
                # If the current box is a stationary obstacle
                elif box[row][column] == '*':
                    # Add a stationary obstacle to the row list
                    row_list.append('*')
                # If the current box is empty
                elif box[row][column] == '.':
                    # Add an empty box to the row list
                    row_list.append('.')
            # Add the row list to the rotated box
            rotated_box.append(row_list)
        # Iterate over the rotated box from top to bottom
        for row in range(0, len(rotated_box)):
            # Iterate over the rotated box from left to right
            for column in range(0, len(rotated_box[row])):
                # If the current box is a stone
                if rotated_box[row][column] == '#':
                    # Iterate over the box from the current row to the bottom
                    for row_below in range(row, len(rotated_box)):
                        # If the box below is a stationary obstacle
                        if rotated_box[row_below][column] == '*':
                            # Swap the current box and the box below
                            rotated_box[row][column], rotated_box[row_below - 1][column] = rotated_box[row_below - 1][column], rotated_box[row][column]
                            # Break out of the loop
                            break
                        # If the box below is empty
                        elif rotated_box[row_below][column] == '.':
                            # Swap