impl Solution {
    pub fn find_lu_slength(strs: Vec<String>) -> i32 {
        

        let mut strs = strs;
        strs.sort_by(|a, b| b.len().cmp(&a.len()));
        for i in 0..strs.len() {
            let mut is_sub = false;
            for j in 0..strs.len() {
                if i == j {
                    continue;
                }
                if Solution::is_sub(&strs[i], &strs[j]) {
                    is_sub = true;
                    break;
                }
            }
            if !is_sub {
                return strs[i].len() as i32;
            }
        }
        -1
    }
    fn is_sub(a: &str, b: &str) -> bool {
        let mut i = 0;
        let mut j = 0;
        while i < a.len() && j < b.len() {
            if a.as_bytes()[i] == b.as_bytes()[j] {
                i += 1;
            }
            j += 1;
        }
        i == a.len()
    }
}