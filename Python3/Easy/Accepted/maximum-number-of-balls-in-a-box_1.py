class Solution:
    def countBalls(self, lowLimit: int, highLimit: int) -> int:
        
        def getSum(num):
            sum = 0
            while num:
                sum += num % 10
                num //= 10
            return sum
        boxes = {}
        for num in range(lowLimit, highLimit + 1):
            box = getSum(num)
            if box in boxes:
                boxes[box] += 1
            else:
                boxes[box] = 1
        return max(boxes.values())