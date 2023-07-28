impl Solution {
    pub fn can_visit_all_rooms(rooms: Vec<Vec<i32>>) -> bool {
        
        let mut visited: Vec<bool> = vec![false; rooms.len()];
        visited[0] = true;
        let mut stack = Vec::new();
        stack.push(0);
        while !stack.is_empty() {
            let room = stack.pop().unwrap();
            for &key in rooms[room].iter() {
                if !visited[key as usize] {
                    visited[key as usize] = true;
                    stack.push(key as usize);
                }
            }
        }
        !visited.contains(&false)
    }
}