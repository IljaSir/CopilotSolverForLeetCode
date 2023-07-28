impl Solution {
    pub fn str_str(haystack: String, needle: String) -> i32 {
        
        if needle.is_empty() {
            return 0;
        }
        if haystack.len() < needle.len() {
            return -1;
        }
        let h = haystack.as_bytes();
        let n = needle.as_bytes();
        for i in 0..h.len() - n.len() + 1 {
            if h[i] == n[0] {
                let mut j = 1;
                while j < n.len() && h[i+j] == n[j] {
                    j += 1;
                }
                if j == n.len() {
                    return i as i32;
                }
            }
        }
        -1
    }
}