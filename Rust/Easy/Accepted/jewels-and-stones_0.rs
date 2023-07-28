impl Solution {
    pub fn num_jewels_in_stones(jewels: String, stones: String) -> i32 {
        
        let mut count = 0;
        for c in stones.chars() {
            if jewels.contains(c) {
                count += 1;
            }
        }
        count
    }
}