impl Solution {
    pub fn distribute_candies(candies: i32, num_people: i32) -> Vec<i32> {
        
        let mut res: Vec<i32> = vec![0; num_people as usize];
        let mut i = 0;
        let mut candies = candies;
        while candies > 0 {
            res[i as usize] += i32::min(candies, i + 1);
            candies -= i + 1;
            i += 1;
            if i as usize == res.len() {
                i = 0;
            }
        }
        res
    }
}