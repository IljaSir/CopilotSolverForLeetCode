impl Solution {
    pub fn distribute_candies(candies: i32, num_people: i32) -> Vec<i32> {
        
        let mut res = vec![0; num_people as usize];
        let mut i: usize = 0;
        let mut candies = candies as usize;
        let mut n = 1;
        while candies > 0 {
            if candies > n {
                res[i] += n as i32;
                candies -= n;
            } else {
                res[i] += candies as i32;
                candies = 0;
            }
            i = (i + 1) % num_people as usize;
            n += 1;
        }
        res
    }
}