impl Solution {
    pub fn can_reach(arr: Vec<i32>, start: i32) -> bool {
        
        let mut visited = vec![false; arr.len()];
        let mut queue = std::collections::VecDeque::new();
        queue.push_back(start as usize);
        while let Some(i) = queue.pop_front() {
            if arr[i] == 0 {
                return true;
            }
            visited[i] = true;
            if (i as i32) + arr[i] < arr.len() as i32 && !visited[((i as i32) + arr[i]) as usize] {
                queue.push_back(((i as i32) + arr[i]) as usize);
            }
            if (i as i32) - arr[i] >= 0 && !visited[((i as i32) - arr[i]) as usize] {
                queue.push_back(((i as i32) - arr[i]) as usize);
            }
        }
        false
    }
}