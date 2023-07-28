impl Solution {
    pub fn can_reach(arr: Vec<i32>, start: i32) -> bool {
        
        let mut visited = vec![false; arr.len()];
        let mut stack = vec![(start, arr[start as usize])];
        while let Some((idx, val)) = stack.pop() {
            if val == 0 {
                return true;
            }
            let idx = idx as usize;
            if visited[idx] {
                continue;
            }
            visited[idx] = true;
            if idx + val as usize < arr.len() {
                stack.push((idx as i32 + val, arr[idx + val as usize]));
            }
            if idx >= val as usize {
                stack.push((idx as i32 - val, arr[idx - val as usize]));
            }
        }
        false
    }
}