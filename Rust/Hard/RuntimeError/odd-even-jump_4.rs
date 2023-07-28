impl Solution {
    pub fn odd_even_jumps(arr: Vec<i32>) -> i32 {
        
        let n = arr.len();
        let mut next_higher = vec![n; n];
        let mut next_lower = vec![n; n];
        let mut stack = vec![];
        for i in (0..n).rev() {
            while !stack.is_empty() && arr[stack[stack.len() - 1]] <= arr[i] {
                stack.pop();
            }
            if !stack.is_empty() {
                next_higher[i] = stack[stack.len() - 1];
            }
            stack.push(i);
        }
        stack.clear();
        for i in (0..n).rev() {
            while !stack.is_empty() && arr[stack[stack.len() - 1]] >= arr[i] {
                stack.pop();
            }
            if !stack.is_empty() {
                next_lower[i] = stack[stack.len() - 1];
            }
            stack.push(i);
        }
        let mut higher = vec![false; n];
        let mut lower = vec![false; n];
        higher[n - 1] = true;
        lower[n - 1] = true;
        let mut ans = 1;
        for i in (0..n - 1).rev() {
            higher[i] = lower[next_higher[i]];
            lower[i] = higher[next_lower[i]];
            if higher[i] {
                ans += 1;
            }
        }
        ans
    }
}