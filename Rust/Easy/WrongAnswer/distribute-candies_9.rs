impl Solution {
    pub fn distribute_candies(candy_type: Vec<i32>) -> i32 {
        
        let mut candy_type = candy_type;
        candy_type.sort();
        let mut count = 0;
        let mut last = candy_type[0];
        for &candy in candy_type.iter() {
            if candy != last {
                count += 1;
                last = candy;
            }
        }
        count.min(candy_type.len() / 2) as i32
    }
}