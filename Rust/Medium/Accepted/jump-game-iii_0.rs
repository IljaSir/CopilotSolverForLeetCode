impl Solution {
    pub fn can_reach(arr: Vec<i32>, start: i32) -> bool {
        
        let mut visited = vec![false; arr.len()];
        let mut stack = vec![start as usize];
        while let Some(i) = stack.pop() {
            if arr[i] == 0 {
                return true;
            }
            visited[i] = true;
            if i as i32 + arr[i] < arr.len() as i32 && !visited[i + arr[i] as usize] {
                stack.push(i + arr[i] as usize);
            }
            if i as i32 - arr[i] >= 0 && !visited[i - arr[i] as usize] {
                stack.push(i - arr[i] as usize);
            }
        }
        false
    }
}