impl Solution {
    pub fn min_deletion_size(strs: Vec<String>) -> i32 {
        
        let mut count = 0;
        for i in 0..strs[0].len() {
            for j in 1..strs.len() {
                if strs[j].as_bytes()[i] < strs[j-1].as_bytes()[i] {
                    count += 1;
                    break;
                }
            }
        }
        count
    }
}