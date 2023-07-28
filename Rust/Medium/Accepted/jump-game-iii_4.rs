impl Solution {
    pub fn can_reach(arr: Vec<i32>, start: i32) -> bool {
        
        let mut visited = vec![false; arr.len()];
        let mut stack = vec![start as usize];
        while let Some(idx) = stack.pop() {
            if arr[idx] == 0 {
                return true;
            }
            if visited[idx] {
                continue;
            }
            visited[idx] = true;
            let left = idx as i32 - arr[idx];
            let right = idx as i32 + arr[idx];
            if left >= 0 {
                stack.push(left as usize);
            }
            if right < arr.len() as i32 {
                stack.push(right as usize);
            }
        }
        false
    }
}