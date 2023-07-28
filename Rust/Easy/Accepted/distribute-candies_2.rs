impl Solution {
    pub fn distribute_candies(candy_type: Vec<i32>) -> i32 {
        
        let mut candy_type = candy_type;
        candy_type.sort();
        let mut count = 1;
        let mut i = 1;
        while i < candy_type.len() {
            if candy_type[i] != candy_type[i - 1] {
                count += 1;
            }
            i += 1;
        }
        (candy_type.len() / 2).min(count) as i32
    }
}