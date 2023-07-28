impl Solution {
    pub fn find_lu_slength(a: String, b: String) -> i32 {
        
        if a == b {
            return -1;
        }
        let len_a = a.len() as i32;
        let len_b = b.len() as i32;
        if len_a > len_b {
            return len_a;
        }
        len_b
    }
}