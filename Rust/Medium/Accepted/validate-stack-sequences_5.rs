impl Solution {
    pub fn validate_stack_sequences(pushed: Vec<i32>, popped: Vec<i32>) -> bool {
        
        let mut stack = Vec::new();
        let mut pushed = pushed;
        let mut popped = popped;
        while !pushed.is_empty() {
            stack.push(pushed.remove(0));
            while !stack.is_empty() && stack[stack.len() - 1] == popped[0] {
                stack.pop();
                popped.remove(0);
            }
        }
        while !stack.is_empty() && stack[stack.len() - 1] == popped[0] {
            stack.pop();
            popped.remove(0);
        }
        stack.is_empty()
    }
}