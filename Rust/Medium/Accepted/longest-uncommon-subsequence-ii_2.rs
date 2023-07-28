impl Solution {
    pub fn find_lu_slength(strs: Vec<String>) -> i32 {
        

        let mut result = -1;
        for i in 0..strs.len() {
            let mut is_subsequence = false;
            for j in 0..strs.len() {
                if i == j {
                    continue;
                }
                if Self::is_subsequence(&strs[i], &strs[j]) {
                    is_subsequence = true;
                    break;
                }
            }
            if !is_subsequence {
                result = result.max(strs[i].len() as i32);
            }
        }
        result
    }

    fn is_subsequence(s: &String, t: &String) -> bool {
        let mut i = 0;
        let mut j = 0;
        while i < s.len() && j < t.len() {
            if s.chars().nth(i).unwrap() == t.chars().nth(j).unwrap() {
                i += 1;
            }
            j += 1;
        }
        i == s.len()
    }
}