impl Solution {
    pub fn distribute_candies(candy_type: Vec<i32>) -> i32 {
        
        let mut candy_type = candy_type;
        candy_type.sort();
        let mut count = 0;
        for i in 0..candy_type.len() {
            if i == 0 || candy_type[i] != candy_type[i - 1] {
                count += 1;
            }
        }
        let n = candy_type.len();
        if count > n / 2 {
            return n as i32 / 2;
        }
        count as i32
    }
}