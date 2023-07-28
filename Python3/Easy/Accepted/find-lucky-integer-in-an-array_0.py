class Solution:
    def findLucky(self, arr: List[int]) -> int:
        
        # Find the frequency of each number in arr
        frequency = {}
        for number in arr:
            if number in frequency:
                frequency[number] += 1
            else:
                frequency[number] = 1
        # Find the largest lucky number
        lucky_numbers = []
        for number in frequency:
            if frequency[number] == number:
                lucky_numbers.append(number)
        return max(lucky_numbers) if lucky_numbers else -1