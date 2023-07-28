impl Solution {
    pub fn count_points(rings: String) -> i32 {
        
        let mut res = 0;
        let mut count = vec![vec![0; 10]; 3];
        for (i, c) in rings.chars().enumerate() {
            count["RGB".find(c).unwrap()][(c as u8 - b'0') as usize] += 1;
            if i % 2 == 1 && count.iter().all(|v| v.iter().any(|&x| x > 0)) {
                res += 1;
            }
        }
        res
    }
}