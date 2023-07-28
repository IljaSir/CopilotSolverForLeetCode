impl Solution {
    pub fn find_lu_slength(strs: Vec<String>) -> i32 {
        

        let mut strs = strs;
        strs.sort_unstable_by(|a, b| b.len().cmp(&a.len()));
        let mut i = 0;
        while i < strs.len() {
            let mut j = 0;
            while j < strs.len() {
                if i != j && strs[i].len() <= strs[j].len() && strs[j].contains(&strs[i]) {
                    break;
                }
                j += 1;
            }
            if j == strs.len() {
                return strs[i].len() as i32;
            }
            i += 1;
        }
        -1
    }
}