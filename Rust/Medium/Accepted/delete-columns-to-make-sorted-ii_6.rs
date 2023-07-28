impl Solution {
    pub fn min_deletion_size(strs: Vec<String>) -> i32 {
        
        let mut sorted = vec![true; strs.len()];
        let mut res = 0;
        for i in 0..strs[0].len() {
            let mut is_sorted = true;
            for j in 1..strs.len() {
                if sorted[j] && strs[j].chars().nth(i).unwrap() < strs[j - 1].chars().nth(i).unwrap() {
                    is_sorted = false;
                    break;
                }
            }
            if !is_sorted {
                res += 1;
            } else {
                for j in 1..strs.len() {
                    if strs[j].chars().nth(i).unwrap() > strs[j - 1].chars().nth(i).unwrap() {
                        sorted[j] = false;
                    }
                }
            }
        }
        res
    }
}