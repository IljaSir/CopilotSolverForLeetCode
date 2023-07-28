impl Solution {
    pub fn kids_with_candies(candies: Vec<i32>, extra_candies: i32) -> Vec<bool> {
        
        let max = candies.iter().max().unwrap();
        let mut ret: Vec<bool> = vec![];
        for i in candies {
            ret.push(i + extra_candies >= *max);
        }
        ret
    }
}