class Solution:
    def countBalls(self, lowLimit: int, highLimit: int) -> int:
        
        boxes = {}
        for num in range(lowLimit, highLimit+1):
            box = sum([int(digit) for digit in str(num)])
            if box in boxes:
                boxes[box] += 1
            else:
                boxes[box] = 1
        return max(boxes.values())