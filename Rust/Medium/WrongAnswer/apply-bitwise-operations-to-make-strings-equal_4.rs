impl Solution {
    pub fn make_strings_equal(s: String, target: String) -> bool {
        
        s.chars().zip(target.chars()).fold(0, |acc, (a, b)| acc + (a as i32 - b as i32)) == 0
    }
}