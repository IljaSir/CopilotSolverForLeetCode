impl Solution {
    pub fn build_array(target: Vec<i32>, n: i32) -> Vec<String> {
        
        let mut res = vec![];
        let mut i = 1;
        for t in target {
            while i < t {
                res.push("Push".to_string());
                res.push("Pop".to_string());
                i += 1;
            }
            res.push("Push".to_string());
            i += 1;
        }
        res
    }
}