class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        
        people.sort()
        boats = 0
        while people:
            people.pop()
            boats += 1
            while people and people[0] + people[-1] <= limit:
                people.pop(0)
        return boats