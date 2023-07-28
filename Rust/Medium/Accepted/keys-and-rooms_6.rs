impl Solution {
    pub fn can_visit_all_rooms(rooms: Vec<Vec<i32>>) -> bool {
        
        let mut visited = vec![false; rooms.len()];
        let mut stack = vec![0];
        visited[0] = true;
        while !stack.is_empty() {
            let cur = stack.pop().unwrap();
            for &i in &rooms[cur as usize] {
                if !visited[i as usize] {
                    visited[i as usize] = true;
                    stack.push(i);
                }
            }
        }
        visited.iter().all(|&x| x)
    }
}