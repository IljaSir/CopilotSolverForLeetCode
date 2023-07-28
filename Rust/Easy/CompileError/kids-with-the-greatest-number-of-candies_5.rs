impl Solution {
    pub fn kids_with_candies(candies: Vec<i32>, extra_candies: i32) -> Vec<bool> {
        
        let max = candies.iter().max().unwrap();
        let mut result = Vec::new();
        for candy in candies {
            result.push(candy + extra_candies >= *max);
        }
        result
    }
}