impl Solution {
    pub fn delete_string(s: String) -> i32 {
        
        let s = s.as_bytes();
        let mut cnt = 0;
        let mut i = 0;
        while i < s.len() {
            let mut j = i + 1;
            while j < s.len() && s[j] == s[i] {
                j += 1;
            }
            let l = j - i;
            cnt += l / 2;
            i = j;
        }
        cnt
    }
}