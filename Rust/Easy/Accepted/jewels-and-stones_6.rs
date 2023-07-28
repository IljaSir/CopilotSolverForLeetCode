impl Solution {
    pub fn num_jewels_in_stones(jewels: String, stones: String) -> i32 {
        
        let mut count = 0;
        for i in 0..stones.len() {
            if jewels.contains(stones.chars().nth(i).unwrap()) {
                count += 1;
            }
        }
        count
    }
}