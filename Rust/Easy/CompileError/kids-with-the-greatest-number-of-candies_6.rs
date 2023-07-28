impl Solution {
    pub fn kids_with_candies(candies: Vec<i32>, extra_candies: i32) -> Vec<bool> {
        
        let max = candies.iter().max().unwrap();
        let mut res = Vec::new();
        for i in candies {
            if i + extra_candies >= *max {
                res.push(true);
            } else {
                res.push(false);
            }
        }
        res
    }
}