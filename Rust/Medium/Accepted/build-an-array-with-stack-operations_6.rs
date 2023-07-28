impl Solution {
    pub fn build_array(target: Vec<i32>, n: i32) -> Vec<String> {
        
        let mut stack = Vec::new();
        let mut i = 0;
        for x in 1..=n {
            if i == target.len() {
                break;
            }
            if x == target[i] {
                i += 1;
                stack.push("Push".to_string());
            } else {
                stack.push("Push".to_string());
                stack.push("Pop".to_string());
            }
        }
        stack
    }
}