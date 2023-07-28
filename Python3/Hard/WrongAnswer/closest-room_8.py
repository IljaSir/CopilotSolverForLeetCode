class Solution:
    def closestRoom(self, rooms: List[List[int]], queries: List[List[int]]) -> List[int]:
        
        # sort rooms by room size
        rooms.sort(key=lambda x: x[1], reverse=True)
        # sort queries by min size
        queries.sort(key=lambda x: x[1], reverse=True)
        # sort rooms by room id
        rooms.sort(key=lambda x: x[0])
        # create a list of query indices
        query_indices = list(range(len(queries)))
        # sort query indices by min size
        query_indices.sort(key=lambda x: queries[x][1], reverse=True)
        # create an empty list to store the answer
        answer = [-1] * len(queries)
        # create a set to store the room ids
        room_ids = set()
        # iterate through the query indices
        for i in query_indices:
            # get the query
            query = queries[i]
            # iterate through the rooms
            for room in rooms:
                # get the room id
                room_id = room[0]
                # get the room size
                room_size = room[1]
                # if the room size is less than the min size
                if room_size < query[1]:
                    # break
                    break
                # if the room id is not in the set
                if room_id not in room_ids:
                    # add the room id to the set
                    room_ids.add(room_id)
                # if the absolute difference between the room id and the preferred
                # is less than the absolute difference between the answer and the preferred
                if abs(room_id - query[0]) < abs(answer[i] - query[0]):
                    # update the answer
                    answer[i] = room_id
                # if the absolute difference between the room id and the preferred
                # is equal to the absolute difference between the answer and the preferred
                elif abs(room_id - query[0]) == abs(answer[i] - query[0]):
                    # if the room id is less than the answer
                    if room_id < answer[i]:
                        # update the answer
                        answer[i] = room_id
        # return the answer
        return answer