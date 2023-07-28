impl Solution {
    pub fn can_reach(arr: Vec<i32>, start: i32) -> bool {
        
        let mut visited = vec![false; arr.len()];
        let mut stack = vec![start as usize];
        while !stack.is_empty() {
            let i = stack.pop().unwrap();
            if visited[i] {
                continue;
            }
            visited[i] = true;
            if arr[i] == 0 {
                return true;
            }
            if i as i32 + arr[i] < arr.len() as i32 {
                stack.push((i as i32 + arr[i]) as usize);
            }
            if i as i32 - arr[i] >= 0 {
                stack.push((i as i32 - arr[i]) as usize);
            }
        }
        false
    }
}