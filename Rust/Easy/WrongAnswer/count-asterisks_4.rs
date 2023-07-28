impl Solution {
    pub fn count_asterisks(s: String) -> i32 {
        
        s.chars().filter(|c| *c == '*').count() as i32
    }
}