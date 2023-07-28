impl Solution {
    pub fn min_deletion_size(strs: Vec<String>) -> i32 {
        
        let mut res = 0;
        for i in 0..strs[0].len() {
            for j in 0..strs.len() - 1 {
                if strs[j].as_bytes()[i] > strs[j + 1].as_bytes()[i] {
                    res += 1;
                    break;
                }
            }
        }
        res
    }
}