impl Solution {
    pub fn count_points(rings: String) -> i32 {
        
        let mut res = 0;
        let mut rods = vec![0; 10];
        for (i, c) in rings.chars().enumerate() {
            if i % 2 == 0 {
                rods[c.to_digit(10).unwrap() as usize] |= 1 << (c as u8 - b'R');
            }
        }
        for rod in rods {
            if rod == 7 {
                res += 1;
            }
        }
        res
    }
}