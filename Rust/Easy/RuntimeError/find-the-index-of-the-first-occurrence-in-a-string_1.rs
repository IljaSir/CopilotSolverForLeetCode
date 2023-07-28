impl Solution {
    pub fn str_str(haystack: String, needle: String) -> i32 {
        
        if needle.len() == 0 {
            return 0;
        }
        for i in 0..haystack.len() - needle.len() + 1 {
            if &haystack[i..i + needle.len()] == needle {
                return i as i32;
            }
        }
        -1
    }
}