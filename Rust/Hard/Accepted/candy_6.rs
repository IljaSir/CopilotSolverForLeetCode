impl Solution {
    pub fn candy(ratings: Vec<i32>) -> i32 {
        
        let mut candies = vec![1; ratings.len()];
        for i in 0..ratings.len() - 1 {
            if ratings[i] < ratings[i + 1] {
                candies[i + 1] = candies[i] + 1;
            }
        }
        for i in (1..ratings.len()).rev() {
            if ratings[i - 1] > ratings[i] && candies[i - 1] <= candies[i] {
                candies[i - 1] = candies[i] + 1;
            }
        }
        candies.iter().sum()
    }
}