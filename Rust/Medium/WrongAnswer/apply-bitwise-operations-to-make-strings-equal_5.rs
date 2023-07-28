impl Solution {
    pub fn make_strings_equal(s: String, target: String) -> bool {
        
        let mut s = s.chars().collect::<Vec<_>>();
        let mut target = target.chars().collect::<Vec<_>>();
        s.sort();
        target.sort();
        s == target
    }
}