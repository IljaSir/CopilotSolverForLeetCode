impl Solution {
    pub fn find_lu_slength(strs: Vec<String>) -> i32 {
        

        let mut strs = strs;
        strs.sort_by(|a, b| b.len().cmp(&a.len()));
        for i in 0..strs.len() {
            let mut j = 0;
            while j < strs.len() {
                if i != j && strs[i].len() <= strs[j].len() {
                    if Self::is_subsequence(&strs[i], &strs[j]) {
                        break;
                    }
                }
                j += 1;
            }
            if j == strs.len() {
                return strs[i].len() as i32;
            }
        }
        -1
    }
    pub fn is_subsequence(a: &String, b: &String) -> bool {
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