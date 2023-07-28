impl Solution {
    pub fn execute_instructions(n: i32, start_pos: Vec<i32>, s: String) -> Vec<i32> {
        
        let mut result = vec![0; s.len()];
        let mut x = start_pos[0];
        let mut y = start_pos[1];
        let mut up = 0;
        let mut down = 0;
        let mut left = 0;
        let mut right = 0;
        for i in 0..s.len() {
            if s.chars().nth(i).unwrap() == 'U' {
                up += 1;
            } else if s.chars().nth(i).unwrap() == 'D' {
                down += 1;
            } else if s.chars().nth(i).unwrap() == 'L' {
                left += 1;
            } else {
                right += 1;
            }
            if x - up + down < 0 || x - up + down >= n || y - left + right < 0 || y - left + right >= n {
                result[i] = 0;
            } else {
                result[i] = s.len() as i32 - i as i32;
            }
        }
        result
    }
}