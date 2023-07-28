impl Solution {
    pub fn validate_stack_sequences(pushed: Vec<i32>, popped: Vec<i32>) -> bool {
        
        let mut stack = Vec::new();
        let mut pushed_idx = 0;
        for i in 0..popped.len() {
            if !stack.is_empty() && stack[stack.len() - 1] == popped[i] {
                stack.pop();
            } else {
                while pushed_idx < pushed.len() && pushed[pushed_idx] != popped[i] {
                    stack.push(pushed[pushed_idx]);
                    pushed_idx += 1;
                }
                if pushed_idx == pushed.len() {
                    return false;
                }
                pushed_idx += 1;
            }
        }
        true
    }
}