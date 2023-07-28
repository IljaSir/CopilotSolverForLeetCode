impl Solution {
    pub fn longest_common_prefix(strs: Vec<String>) -> String {
        
        if strs.len() == 0 {
            return "".to_string();
        }
        let mut result = strs[0].clone();
        for i in 1..strs.len() {
            let mut j = 0;
            while j < result.len() && j < strs[i].len() && result.chars().nth(j) == strs[i].chars().nth(j) {
                j += 1;
            }
            result = result[0..j].to_string();
        }
        result
    }
}