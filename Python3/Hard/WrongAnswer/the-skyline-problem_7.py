class Solution:
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        
        # 1. Divide & Conquer
        # Time  complexity: O(NlogN)
        # Space complexity: O(N)
        def merge_skylines(left, right):
            """
            Merge two skylines together.
            """
            nL, nR = len(left), len(right)
            # the final output array
            output = []
            # current position in left and right lists
            pl = pr = 0
            # current height of left and right skylines
            Hl = Hr = 0
            # current x-position
            curr_x = 0
            # while we're in the region where both skylines are present
            while pl < nL and pr < nR:
                # pick up the smallest x
                if left[pl][0] < right[pr][0]:
                    curr_x, Hl = left[pl]
                    pl += 1
                else:
                    curr_x, Hr = right[pr]
                    pr += 1
                # max height (i.e. y) between both skylines
                max_H = max(Hl, Hr)
                # if the skyline has changed, update the output
                if not output or output[-1][1] != max_H:
                    update_output(curr_x, max_H)

            # there is only left skyline
            while pl < nL:
                curr_x, Hl = left[pl]
                pl += 1
                max_H = max(Hl, Hr)
                if not output or output[-1][1] != max_H:
                    update_output(curr_x, max_H)

            # there is only right skyline
            while pr < nR:
                curr_x, Hr = right[pr]
                pr += 1
                max_H = max(Hl, Hr)
                if not output or output[-1][1] != max_H:
                    update_output(curr_x, max_H)

            return output

        def update_output(x, y):
            """
            Update the final output with the new element.
            """
            # if skyline change is not vertical - add the new point
            if not output or output[-1][0] != x:
                output.append([x, y])
            # if skyline change is vertical - update the last point
            else:
                output[-1][1] = y