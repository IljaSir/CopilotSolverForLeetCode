impl Solution {
    pub fn num_jewels_in_stones(jewels: String, stones: String) -> i32 {
        
        let mut count = 0;
        for ch in jewels.chars() {
            for ch2 in stones.chars() {
                if ch == ch2 {
                    count += 1;
                }
            }
        }
        count
    }
}