impl Solution {
    pub fn find_lu_slength(strs: Vec<String>) -> i32 {
        

        let mut strs: Vec<Vec<char>> = strs.into_iter().map(|s| s.chars().collect()).collect();
        strs.sort_by(|a, b| b.len().cmp(&a.len()));
        for (i, a) in strs.iter().enumerate() {
            let mut is_subsequence = false;
            for (j, b) in strs.iter().enumerate() {
                if i == j {
                    continue;
                }
                if is_subsequence(a, b) {
                    is_subsequence = true;
                    break;
                }
            }
            if !is_subsequence {
                return a.len() as i32;
            }
        }
        -1
    }
}