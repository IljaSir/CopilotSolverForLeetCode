impl Solution {
    pub fn build_array(target: Vec<i32>, n: i32) -> Vec<String> {
        
        let mut stack = Vec::new();
        let mut j = 1;
        for i in 0..target.len() {
            while j < target[i] {
                stack.push("Push".to_string());
                stack.push("Pop".to_string());
                j += 1;
            }
            stack.push("Push".to_string());
            j += 1;
        }
        stack
    }
}