impl Solution {
    pub fn can_reach(arr: Vec<i32>, start: i32) -> bool {
        
        let mut visited = vec![false; arr.len()];
        let mut stack = Vec::new();
        stack.push(start as usize);
        while !stack.is_empty() {
            let index = stack.pop().unwrap();
            if arr[index] == 0 {
                return true;
            }
            visited[index] = true;
            let left = (index as i32 - arr[index]) as usize;
            if left < arr.len() && !visited[left] {
                stack.push(left);
            }
            let right = (index as i32 + arr[index]) as usize;
            if right < arr.len() && !visited[right] {
                stack.push(right);
            }
        }
        false
    }
}