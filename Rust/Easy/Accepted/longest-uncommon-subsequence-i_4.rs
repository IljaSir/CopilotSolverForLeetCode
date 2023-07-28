impl Solution {
    pub fn find_lu_slength(a: String, b: String) -> i32 {
        
        let a = a.as_bytes();
        let b = b.as_bytes();
        if a == b {
            return -1;
        }
        a.len().max(b.len()) as i32
    }
}