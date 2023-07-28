impl Solution {
    pub fn count_points(rings: String) -> i32 {
        
        let mut count = 0;
        let mut rods = vec![0; 10];
        for (i, c) in rings.chars().enumerate() {
            if i % 2 == 0 {
                rods[c.to_digit(10).unwrap() as usize] += 1;
            }
        }
        for i in rods {
            if i == 3 {
                count += 1;
            }
        }
        count
    }
}