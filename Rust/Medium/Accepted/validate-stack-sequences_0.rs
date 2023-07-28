impl Solution {
    pub fn validate_stack_sequences(pushed: Vec<i32>, popped: Vec<i32>) -> bool {
        
        let mut stack: Vec<i32> = vec![];
        let mut j = 0;
        for i in 0..pushed.len() {
            stack.push(pushed[i]);
            while !stack.is_empty() && stack[stack.len()-1] == popped[j] {
                stack.pop();
                j += 1;
            }
        }
        stack.is_empty()
    }
}