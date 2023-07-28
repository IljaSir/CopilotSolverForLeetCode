impl Solution {
    pub fn validate_stack_sequences(pushed: Vec<i32>, popped: Vec<i32>) -> bool {
        
        let mut stack = Vec::new();
        let mut i = 0;
        for x in pushed {
            stack.push(x);
            while !stack.is_empty() && stack[stack.len() - 1] == popped[i] {
                stack.pop();
                i += 1;
            }
        }
        stack.is_empty()
    }
}