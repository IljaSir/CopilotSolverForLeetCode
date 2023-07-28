impl Solution {
    pub fn make_strings_equal(s: String, target: String) -> bool {
        
        let mut s = s.into_bytes();
        let mut target = target.into_bytes();
        let mut count = 0;
        for i in 0..s.len() {
            if s[i] != target[i] {
                count += 1;
            }
        }
        count % 2 == 0
    }
}