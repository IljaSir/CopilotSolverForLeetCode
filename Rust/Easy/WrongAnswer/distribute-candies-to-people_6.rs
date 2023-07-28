impl Solution {
    pub fn distribute_candies(candies: i32, num_people: i32) -> Vec<i32> {
        
        let mut res = vec![0; num_people as usize];
        let mut c = candies;
        let mut i = 0;
        while c > 0 {
            res[i] += if c > i as i32 + 1 { i as i32 + 1 } else { c };
            c -= i as i32 + 1;
            i = (i + 1) % num_people as usize;
        }
        res
    }
}