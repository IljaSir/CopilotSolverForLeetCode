class Solution:
    def getOrder(self, tasks: List[List[int]]) -> List[int]:
        
        # sort by enqueueTime
        tasks = sorted(tasks, key=lambda x: x[0])
        # sort by processingTime
        tasks = sorted(tasks, key=lambda x: x[1])
        # sort by enqueueTime
        tasks = sorted(tasks, key=lambda x: x[0])

        # print(tasks)

        # initialize a heap
        heap = []
        # initialize a result array
        result = []
        # initialize a current time
        current_time = 0
        # initialize a current index
        current_index = 0
        # initialize a number of tasks
        number_of_tasks = len(tasks)
        # while there are tasks to process
        while current_index < number_of_tasks:
            # while there are tasks to process and the enqueueTime is less than or equal to the current_time
            while current_index < number_of_tasks and tasks[current_index][0] <= current_time:
                # push the task into the heap
                heapq.heappush(heap, (tasks[current_index][1], tasks[current_index][0], current_index))
                # increment the current_index
                current_index += 1
            # if the heap is empty
            if not heap:
                # set the current_time to the enqueueTime of the next task
                current_time = tasks[current_index][0]
            # otherwise
            else:
                # pop the task from the heap
                processing_time, enqueue_time, index = heapq.heappop(heap)
                # append the index to the result
                result.append(index)
                # increment the current_time by the processing_time
                current_time += processing_time
        # return the result
        return result