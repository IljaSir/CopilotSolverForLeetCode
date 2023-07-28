class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        
        # sort people by height in descending order and by the number of people in front of them in ascending order
        people.sort(key=lambda x: (-x[0], x[1]))
        # print(people)
        # init the queue with the same length as the people list
        queue = [None] * len(people)
        # print(queue)
        # iterate over the people list
        for person in people:
            # print(person)
            # print(queue)
            # print(person[1])
            # insert the person in the queue at the index of the number of people in front of them
            queue[person[1]:person[1]] = [person]
            # print(queue)
        # return the queue
        return queue