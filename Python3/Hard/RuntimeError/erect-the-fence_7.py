class Solution:
    def outerTrees(self, trees: List[List[int]]) -> List[List[int]]:
        
        # Find the leftmost point
        leftmost = 0
        for i in range(1, len(trees)):
            if trees[i][0] < trees[leftmost][0]:
                leftmost = i
        # The leftmost is the starting point
        start = leftmost
        # The result
        result = []
        while True:
            # Add the current point to the result
            result.append(trees[start])
            # The next point
            next = (start + 1) % len(trees)
            # Find the next point
            for i in range(len(trees)):
                if self.orientation(trees[start], trees[i], trees[next]) < 0:
                    next = i
            # If the next point is the starting point, we are done
            if next == leftmost:
                break
            # Otherwise, move to the next point
            start = next
        return result