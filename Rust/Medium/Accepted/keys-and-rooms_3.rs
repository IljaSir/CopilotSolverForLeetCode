impl Solution {
    pub fn can_visit_all_rooms(rooms: Vec<Vec<i32>>) -> bool {
        
        let mut visited = vec![false; rooms.len()];
        visited[0] = true;
        let mut stack = vec![0];
        while let Some(i) = stack.pop() {
            for &j in &rooms[i] {
                if !visited[j as usize] {
                    visited[j as usize] = true;
                    stack.push(j as usize);
                }
            }
        }
        visited.iter().all(|&b| b)
    }
}