impl Solution {
    pub fn str_str(haystack: String, needle: String) -> i32 {
        
        if needle.len() == 0 {
            return 0;
        }
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        let mut index = -1;
        let haystack = haystack.as_bytes();
        let needle = needle.as_bytes();
        while i < haystack.len() {
            if haystack[i] == needle[j] {
                if index == -1 {
                    index = i as i32;
                }
                j += 1;
                if j == needle.len() {
                    return index;
                }
            } else {
                if index != -1 {
                    i = k;
                    j = 0;
                    index = -1;
                }
                k += 1;
            }
            i += 1;
        }
        return -1;
    }
}