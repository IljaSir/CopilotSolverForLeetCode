impl Solution {
    pub fn poor_pigs(buckets: i32, minutes_to_die: i32, minutes_to_test: i32) -> i32 {
        
        (minutes_to_test / minutes_to_die + 1).log(buckets as u32) as i32
    }
}