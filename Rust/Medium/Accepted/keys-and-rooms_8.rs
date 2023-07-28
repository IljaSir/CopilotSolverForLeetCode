impl Solution {
    pub fn can_visit_all_rooms(rooms: Vec<Vec<i32>>) -> bool {
        
        let mut visited = vec![false; rooms.len()];
        let mut stack = vec![];
        stack.push(0);
        while let Some(room) = stack.pop() {
            if visited[room] {
                continue;
            }
            visited[room] = true;
            for &key in &rooms[room] {
                stack.push(key as usize);
            }
        }
        visited.iter().all(|&v| v)
    }
}