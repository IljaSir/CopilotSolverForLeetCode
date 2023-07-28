impl Solution {
    pub fn min_deletion_size(strs: Vec<String>) -> i32 {
        
        let mut count = 0;
        for i in 0..strs[0].len() {
            let mut prev = '0';
            for j in 0..strs.len() {
                if prev > strs[j].chars().nth(i).unwrap() {
                    count += 1;
                    break;
                }
                prev = strs[j].chars().nth(i).unwrap();
            }
        }
        count
    }
}