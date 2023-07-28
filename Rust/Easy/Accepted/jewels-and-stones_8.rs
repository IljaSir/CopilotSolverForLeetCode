impl Solution {
    pub fn num_jewels_in_stones(jewels: String, stones: String) -> i32 {
        
        let mut count = 0;
        for i in jewels.chars() {
            count += stones.matches(i).count() as i32;
        }
        count
    }
}