impl Solution {
    pub fn num_teams(rating: Vec<i32>) -> i32 {
        
        let mut count = 0;
        for (i, &a) in rating.iter().enumerate() {
            for (j, &b) in rating[i+1..].iter().enumerate() {
                for &c in &rating[i+j+2..] {
                    if a < b && b < c || a > b && b > c {
                        count += 1;
                    }
                }
            }
        }
        count
    }
}