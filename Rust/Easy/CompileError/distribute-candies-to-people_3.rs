impl Solution {
    pub fn distribute_candies(candies: i32, num_people: i32) -> Vec<i32> {
        
        let mut ans = vec![0; num_people as usize];
        let mut i = 0;
        let mut candy = 1;
        while candies > 0 {
            ans[i] += candy;
            candies -= candy;
            candy += 1;
            i += 1;
            if i == ans.len() {
                i = 0;
            }
            if candies < candy {
                candy = candies;
            }
        }
        ans
    }
}