impl Solution {
    pub fn truncate_sentence(s: String, k: i32) -> String {
        
        let mut count = 0;
        let mut ret = String::new();
        for ch in s.chars() {
            if ch == ' ' {
                count += 1;
                if count == k {
                    break;
                }
            }
            ret.push(ch);
        }
        ret
    }
}