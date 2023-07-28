impl Solution {
    pub fn make_strings_equal(s: String, target: String) -> bool {
        
        let mut s = s.chars().collect::<Vec<char>>();
        let mut target = target.chars().collect::<Vec<char>>();
        s.sort();
        target.sort();
        s == target
    }
}