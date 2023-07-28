impl Solution {
    pub fn str_str(haystack: String, needle: String) -> i32 {
        
        if needle.is_empty() {
            return 0;
        }
        if haystack.len() < needle.len() {
            return -1;
        }
        let haystack = haystack.as_bytes();
        let needle = needle.as_bytes();
        let mut i = 0;
        while i < haystack.len() {
            let mut j = 0;
            while j < needle.len() && i + j < haystack.len() {
                if haystack[i + j] != needle[j] {
                    break;
                }
                j += 1;
            }
            if j == needle.len() {
                return i as i32;
            }
            i += 1;
        }
        -1
    }
}