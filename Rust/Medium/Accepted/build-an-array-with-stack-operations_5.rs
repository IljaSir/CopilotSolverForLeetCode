impl Solution {
    pub fn build_array(target: Vec<i32>, n: i32) -> Vec<String> {
        
        let mut result = Vec::new();
        let mut i = 0;
        for j in 1..=n {
            if i == target.len() {
                break;
            }
            if j == target[i] {
                result.push("Push".to_string());
                i += 1;
            } else {
                result.push("Push".to_string());
                result.push("Pop".to_string());
            }
        }
        result
    }
}