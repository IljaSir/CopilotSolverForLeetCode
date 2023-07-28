impl Solution {
    pub fn count_points(rings: String) -> i32 {
        
        let mut r = 0;
        let mut g = 0;
        let mut b = 0;
        let mut res = 0;
        for i in 0..rings.len() {
            match rings.chars().nth(i).unwrap() {
                'R' => r += 1,
                'G' => g += 1,
                'B' => b += 1,
                _ => (),
            }
            if i % 2 == 1 {
                if r > 0 && g > 0 && b > 0 {
                    res += 1;
                }
                r = 0;
                g = 0;
                b = 0;
            }
        }
        
        res
    }
}