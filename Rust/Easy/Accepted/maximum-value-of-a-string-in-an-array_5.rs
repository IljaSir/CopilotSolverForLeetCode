impl Solution {
    pub fn maximum_value(strs: Vec<String>) -> i32 {
        
        let mut max = 0;
        for s in strs {
            if s.chars().all(|c| c.is_numeric()) {
                max = max.max(s.parse::<i32>().unwrap());
            } else {
                max = max.max(s.len() as i32);
            }
        }
        max
    }
}