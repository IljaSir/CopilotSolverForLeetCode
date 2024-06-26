impl Solution {
    pub fn validate_stack_sequences(pushed: Vec<i32>, popped: Vec<i32>) -> bool {
        
        let mut stack = vec![];
        let mut i = 0;
        for &num in &pushed {
            stack.push(num);
            while let Some(&top) = stack.last() {
                if top == popped[i] {
                    stack.pop();
                    i += 1;
                } else {
                    break;
                }
            }
        }
        stack.is_empty()
    }
}