impl Solution {
    pub fn find_lu_slength(strs: Vec<String>) -> i32 {
        

        let mut strs = strs;
        strs.sort_by(|a, b| b.len().cmp(&a.len()));
        for i in 0..strs.len() {
            let mut found = false;
            for j in 0..strs.len() {
                if i != j && strs[j].contains(&strs[i]) {
                    found = true;
                    break;
                }
            }
            if !found {
                return strs[i].len() as i32;
            }
        }
        -1
    }
}