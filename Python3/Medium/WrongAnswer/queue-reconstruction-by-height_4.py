class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        
        people.sort()
        # print(people)
        res = []
        for p in people:
            res.insert(p[1], p)
        return res