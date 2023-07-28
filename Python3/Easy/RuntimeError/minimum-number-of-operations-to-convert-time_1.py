class Solution:
    def convertTime(self, current: str, correct: str) -> int:
        
        
        def convert(time):
            h, m = time.split(':')
            return int(h)*60 + int(m)
        
        def revert(time):
            h = time // 60
            m = time % 60
            return str(h).zfill(2) + ':' + str(m).zfill(2)
        
        def get_next_time(time, step):
            time = convert(time)
            time = time + step
            return revert(time)
        
        def get_next_times(time):
            for step in [1, 5, 15, 60]:
                yield get_next_time(time, step)
        
        def get_next_times_with_level(time, level):
            for step in [1, 5, 15, 60]:
                yield get_next_time(time, step), level + 1
        
        def get_next_times_with_level_and_visited(time, level, visited):
            for step in [1, 5, 15, 60]:
                next_time = get_next_time(time, step)
                if next_time not in visited:
                    yield next_time, level + 1
        
        def get_next_times_with_level_and_visited_and_parent(time, level, visited, parent):
            for step in [1, 5, 15, 60]:
                next_time = get_next_time(time, step)
                if next_time not in visited:
                    yield next_time, level + 1, parent
        
        def get_next_times_with_level_and_visited_and_parent_and_path(time, level, visited, parent, path):
            for step in [1, 5, 15, 60]:
                next_time = get_next_time(time, step)
                if next_time not in visited:
                    yield next_time, level + 1, parent, path + [next_time]
        
        def bfs(current, correct):
            queue = [(current, 0)]
            visited = set()
            while queue:
                time, level = queue.pop(0)
                if time == correct:
                    return level
                for next_time in get_next_times(time):
                    if next_time not in visited:
                        queue.append((next_time, level + 1))
                        visited.add(next_time)
        
        def bfs_with_level(current, correct):
            queue = [(current, 0)]
            visited = set()
            while queue:
                time, level = queue.pop(0)
                if time == correct: