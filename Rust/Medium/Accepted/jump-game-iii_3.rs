impl Solution {
    pub fn can_reach(arr: Vec<i32>, start: i32) -> bool {
        
        let n = arr.len();
        let mut visited = vec![false; n];
        let mut q = std::collections::VecDeque::new();
        q.push_back(start as usize);
        while let Some(i) = q.pop_front() {
            if arr[i] == 0 {
                return true;
            }
            if visited[i] {
                continue;
            }
            visited[i] = true;
            if i as i32 + arr[i] < n as i32 {
                q.push_back((i as i32 + arr[i]) as usize);
            }
            if i as i32 - arr[i] >= 0 {
                q.push_back((i as i32 - arr[i]) as usize);
            }
        }
        false
    }
}