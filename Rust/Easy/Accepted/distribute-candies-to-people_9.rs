impl Solution {
    pub fn distribute_candies(candies: i32, num_people: i32) -> Vec<i32> {
        
        let mut result = vec![0; num_people as usize];
        let mut candies = candies;
        let mut loop_count = 1;
        while candies > 0 {
            for i in 0..num_people {
                let c = loop_count + i;
                if candies >= c {
                    result[i as usize] += c;
                    candies -= c;
                } else {
                    result[i as usize] += candies;
                    candies = 0;
                }
            }
            loop_count += num_people;
        }
        result
    }
}