impl Solution {
    pub fn validate_stack_sequences(pushed: Vec<i32>, popped: Vec<i32>) -> bool {
        
        let mut stack = Vec::new();
        let mut i = 0;
        for a in pushed {
            stack.push(a);
            while let Some(&b) = stack.last() {
                if b == popped[i] {
                    i += 1;
                    stack.pop();
                } else {
                    break;
                }
            }
        }
        i == popped.len()
    }
}