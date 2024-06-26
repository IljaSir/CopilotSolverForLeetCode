impl Solution {
    pub fn min_deletion_size(strs: Vec<String>) -> i32 {
        
        let mut count = 0;
        for i in 0..strs[0].len() {
            for j in 0..strs.len() - 1 {
                if strs[j].chars().nth(i) > strs[j + 1].chars().nth(i) {
                    count += 1;
                    break;
                }
            }
        }
        count
    }
}