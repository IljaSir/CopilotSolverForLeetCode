impl Solution {
    pub fn can_visit_all_rooms(rooms: Vec<Vec<i32>>) -> bool {
        
        let mut visited = vec![false; rooms.len()];
        let mut stack = vec![0];
        visited[0] = true;
        while !stack.is_empty() {
            let room = stack.pop().unwrap();
            for key in &rooms[room] {
                if !visited[*key as usize] {
                    visited[*key as usize] = true;
                    stack.push(*key as usize);
                }
            }
        }
        visited.iter().all(|b| *b)
    }
}