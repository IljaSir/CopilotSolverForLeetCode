impl Solution {
    pub fn can_visit_all_rooms(rooms: Vec<Vec<i32>>) -> bool {
        
        let mut visited = vec![false; rooms.len()];
        let mut stack = vec![];
        stack.push(0);
        while !stack.is_empty() {
            let room = stack.pop().unwrap();
            if !visited[room as usize] {
                visited[room as usize] = true;
                for &key in rooms[room as usize].iter() {
                    stack.push(key);
                }
            }
        }
        !visited.contains(&false)
    }
}