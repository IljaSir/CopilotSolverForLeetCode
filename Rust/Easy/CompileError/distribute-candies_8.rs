impl Solution {
    pub fn distribute_candies(candy_type: Vec<i32>) -> i32 {
        
        let mut candy_type = candy_type;
        candy_type.sort();
        let mut candy_type = candy_type.into_iter().unique();
        let mut count = 0;
        while let Some(_) = candy_type.next() {
            count += 1;
        }
        let n = candy_type.len();
        let m = candy_type.len() / 2;
        if count > m {
            m as i32
        } else {
            count as i32
        }
    }
}