class Solution:
    def closestRoom(self, rooms: List[List[int]], queries: List[List[int]]) -> List[int]:
        
        
        # sort rooms by size
        rooms.sort(key=lambda x: x[1], reverse=True)
        # sort queries by size
        queries.sort(key=lambda x: x[1], reverse=True)
        
        # index rooms by id
        room_dict = {}
        for room in rooms:
            room_dict[room[0]] = room[1]
        
        # sort rooms by id
        rooms.sort(key=lambda x: x[0])
        
        # sort queries by preferred
        queries.sort(key=lambda x: x[0])
        
        # use binary search to find the closest room
        # for each query
        # if the room is too small, skip it
        # if the room is too big, stop searching
        def binary_search(target, start, end):
            if start > end:
                return -1
            mid = (start + end) // 2
            if rooms[mid][1] >= target:
                return binary_search(target, mid+1, end)
            else:
                return binary_search(target, start, mid-1)
        
        # output
        result = []
        for query in queries:
            # find the closest room
            closest = binary_search(query[1], 0, len(rooms)-1)
            if closest == -1:
                result.append(-1)
            else:
                closest_room = rooms[closest][0]
                # find the closest room from the closest room
                # to the preferred room
                closest = binary_search(query[1], closest, len(rooms)-1)
                if closest == -1:
                    result.append(-1)
                else:
                    for