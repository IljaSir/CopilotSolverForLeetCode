impl Solution {
    pub fn str_str(haystack: String, needle: String) -> i32 {
        
        if needle.is_empty() {
            return 0;
        }
        let haystack: Vec<char> = haystack.chars().collect();
        let needle: Vec<char> = needle.chars().collect();
        let mut i = 0;
        while i < haystack.len() {
            if haystack[i] == needle[0] {
                let mut j = 0;
                while j < needle.len() && i < haystack.len() {
                    if haystack[i] != needle[j] {
                        break;
                    }
                    i += 1;
                    j += 1;
                }
                if j == needle.len() {
                    return i as i32 - j as i32;
                }
            } else {
                i += 1;
            }
        }
        -1
    }
}