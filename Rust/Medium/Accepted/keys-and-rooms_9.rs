impl Solution {
    pub fn can_visit_all_rooms(rooms: Vec<Vec<i32>>) -> bool {
        
        let mut visited = vec![false;rooms.len()];
        let mut stack = vec![0];
        while let Some(cur) = stack.pop() {
            if visited[cur] {
                continue;
            }
            visited[cur] = true;
            for &next in &rooms[cur] {
                if !visited[next as usize] {
                    stack.push(next as usize);
                }
            }
        }
        visited.iter().all(|&x| x)
    }
}