impl Solution {
    pub fn str_str(haystack: String, needle: String) -> i32 {
        
        if haystack == needle || needle.is_empty() { return 0; }
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        let mut result = -1;
        while i < haystack.len() {
            if haystack.chars().nth(i) == needle.chars().nth(j) {
                if j == 0 { k = i; }
                if j == needle.len() - 1 { return k as i32; }
                j += 1;
            } else {
                j = 0;
            }
            i += 1;
        }
        result
    }
}