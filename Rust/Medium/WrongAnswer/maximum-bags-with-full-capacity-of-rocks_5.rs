impl Solution {
    pub fn maximum_bags(capacity: Vec<i32>, rocks: Vec<i32>, additional_rocks: i32) -> i32 {
        
        let mut v = capacity.iter().zip(rocks.iter()).map(|(c, r)| *c - *r).collect::<Vec<i32>>();
        v.sort();
        let mut sum = 0;
        let mut i = 0;
        while i < v.len() && sum <= additional_rocks {
            sum += v[i];
            i += 1;
        }
        i as i32
    }
}