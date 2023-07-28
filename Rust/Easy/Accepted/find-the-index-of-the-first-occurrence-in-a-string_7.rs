impl Solution {
    pub fn str_str(haystack: String, needle: String) -> i32 {
        
        if needle.len() == 0 { return 0; }
        if haystack.len() < needle.len() { return -1; }
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        let mut result = -1;
        let mut found = false;
        while i < haystack.len() {
            if haystack.as_bytes()[i] == needle.as_bytes()[j] {
                if !found {
                    k = i;
                    found = true;
                }
                i += 1;
                j += 1;
                if j == needle.len() {
                    result = k as i32;
                    break;
                }
            } else {
                if found {
                    i = k + 1;
                    j = 0;
                    found = false;
                } else {
                    i += 1;
                }
            }
        }
        result
    }
}