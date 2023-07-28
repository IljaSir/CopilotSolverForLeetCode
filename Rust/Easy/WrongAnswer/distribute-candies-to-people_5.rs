impl Solution {
    pub fn distribute_candies(candies: i32, num_people: i32) -> Vec<i32> {
        
        let mut result = vec![0; num_people as usize];
        let mut i = 0;
        let mut candies = candies;
        while candies > 0 {
            result[i] += if candies > i as i32 + 1 {
                i as i32 + 1
            } else {
                candies
            };
            candies -= i as i32 + 1;
            i += 1;
            if i == num_people as usize {
                i = 0;
            }
        }
        result
    }
}