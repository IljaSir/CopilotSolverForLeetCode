impl Solution {
    pub fn min_deletion_size(strs: Vec<String>) -> i32 {
        
        let mut cnt = 0;
        for i in 0..strs[0].len() {
            for j in 1..strs.len() {
                if strs[j].chars().nth(i).unwrap() < strs[j-1].chars().nth(i).unwrap() {
                    cnt += 1;
                    break;
                }
            }
        }
        cnt
    }
}