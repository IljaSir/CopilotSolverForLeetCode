impl Solution {
    pub fn truncate_sentence(s: String, k: i32) -> String {
        
        let mut c = 0;
        let mut r = String::new();
        for i in s.chars() {
            if i == ' ' {
                c += 1;
            }
            if c == k {
                break;
            }
            r.push(i);
        }
        r
    }
}