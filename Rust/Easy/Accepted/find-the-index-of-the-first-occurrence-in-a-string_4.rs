impl Solution {
    pub fn str_str(haystack: String, needle: String) -> i32 {
        
        if needle == "" {
            return 0;
        }
        if haystack == "" {
            return -1;
        }
        if haystack.len() < needle.len() {
            return -1;
        }
        for i in 0..haystack.len() - needle.len() + 1 {
            if &haystack[i..i + needle.len()] == needle {
                return i as i32;
            }
        }
        return -1;
    }
}