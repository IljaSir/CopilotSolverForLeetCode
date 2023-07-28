impl Solution {
    pub fn num_jewels_in_stones(jewels: String, stones: String) -> i32 {
        
        let mut result = 0;
        for c in jewels.chars() {
            result += stones.matches(c).count() as i32;
        }
        result
    }
}