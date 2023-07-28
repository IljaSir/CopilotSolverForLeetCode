impl Solution {
    pub fn distribute_candies(candies: i32, num_people: i32) -> Vec<i32> {
        
        let mut ans = vec![0; num_people as usize];
        let mut i = 0;
        let mut candies = candies;
        while candies > 0 {
            ans[i] += i32::min(candies, i as i32 + 1);
            candies -= i32::min(candies, i as i32 + 1);
            i = (i + 1) % num_people as usize;
        }
        ans
    }
}