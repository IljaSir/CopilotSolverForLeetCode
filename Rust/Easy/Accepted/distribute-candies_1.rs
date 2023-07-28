impl Solution {
    pub fn distribute_candies(candy_type: Vec<i32>) -> i32 {
        
        let n = candy_type.len() / 2;
        let mut candy_type = candy_type;
        candy_type.sort();
        candy_type.dedup();
        let m = candy_type.len();
        if n < m {
            n as i32
        } else {
            m as i32
        }
    }
}