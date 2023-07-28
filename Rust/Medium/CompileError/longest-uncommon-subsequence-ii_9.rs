impl Solution {
    pub fn find_lu_slength(strs: Vec<String>) -> i32 {
        

        let mut strs = strs;
        strs.sort_by(|a, b| b.len().cmp(&a.len()));
        let mut res = -1;
        for i in 0..strs.len() {
            if strs[i..].iter().any(|s| s == &strs[i]) {
                continue;
            }
            if strs[..i].iter().all(|s| !is_subsequence(&strs[i], s)) {
                res = strs[i].len() as i32;
                break;
            }
        }
        res
    }
}