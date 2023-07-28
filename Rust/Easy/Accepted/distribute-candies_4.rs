impl Solution {
    pub fn distribute_candies(candy_type: Vec<i32>) -> i32 {
        
        let n = candy_type.len() / 2;
        let mut candy_type = candy_type;
        candy_type.sort();
        let mut unique_candies = 1;
        for i in 1..candy_type.len() {
            if candy_type[i] != candy_type[i-1] {
                unique_candies += 1;
            }
        }
        unique_candies.min(n) as i32
    }
}