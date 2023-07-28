impl Solution {
    pub fn can_reach(arr: Vec<i32>, start: i32) -> bool {
        
        let mut visited = vec![false; arr.len()];
        let mut queue = Vec::new();
        queue.push(start as usize);
        while !queue.is_empty() {
            let i = queue.pop().unwrap();
            if arr[i] == 0 {
                return true;
            }
            if visited[i] {
                continue;
            }
            visited[i] = true;
            if i as i32 + arr[i] < arr.len() as i32 {
                queue.push((i as i32 + arr[i]) as usize);
            }
            if i as i32 - arr[i] >= 0 {
                queue.push((i as i32 - arr[i]) as usize);
            }
        }
        false
    }
}