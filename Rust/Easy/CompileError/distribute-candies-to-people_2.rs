impl Solution {
    pub fn distribute_candies(candies: i32, num_people: i32) -> Vec<i32> {
        
        let mut res = vec![0; num_people as usize];
        let mut i = 0;
        let mut candy = 1;
        while candies > 0 {
            res[i] += candy.min(candies);
            candies -= candy;
            candy += 1;
            i = (i + 1) % num_people as usize;
        }
        res
    }
}