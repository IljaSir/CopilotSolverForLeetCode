impl Solution {
    pub fn build_array(target: Vec<i32>, n: i32) -> Vec<String> {
        
        let mut stack: Vec<i32> = Vec::new();
        let mut res: Vec<String> = Vec::new();
        let mut i = 0;
        for num in 1..=n {
            if i == target.len() {
                break;
            }
            if num == target[i] {
                res.push("Push".to_string());
                i += 1;
            } else {
                res.push("Push".to_string());
                res.push("Pop".to_string());
            }
        }
        res
    }
}