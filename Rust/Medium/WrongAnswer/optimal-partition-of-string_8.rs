impl Solution {
    pub fn partition_string(s: String) -> i32 {
        
        let mut max_index = 0;
        let mut result = 0;
        let mut index = 0;
        for (i, c) in s.chars().enumerate() {
            max_index = max_index.max(s.rfind(c).unwrap());
            if i == max_index {
                result += 1;
                index = i + 1;
            }
        }
        result
    }
}