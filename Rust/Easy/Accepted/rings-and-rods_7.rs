impl Solution {
    pub fn count_points(rings: String) -> i32 {
        
        let mut res = 0;
        let mut arr = vec![[0; 3]; 10];
        for (i, c) in rings.chars().enumerate() {
            if i % 2 == 0 {
                match c {
                    'R' => arr[rings.chars().nth(i + 1).unwrap().to_digit(10).unwrap() as usize][0] += 1,
                    'G' => arr[rings.chars().nth(i + 1).unwrap().to_digit(10).unwrap() as usize][1] += 1,
                    'B' => arr[rings.chars().nth(i + 1).unwrap().to_digit(10).unwrap() as usize][2] += 1,
                    _ => (),
                }
            }
        }
        for i in 0..10 {
            if arr[i][0] > 0 && arr[i][1] > 0 && arr[i][2] > 0 {
                res += 1;
            }
        }
        res
    }
}