impl Solution {
    pub fn count_points(rings: String) -> i32 {
        
        let mut result = 0;
        let mut rods = [[false; 3]; 10];
        for i in 0..rings.len() / 2 {
            rods[rings.chars().nth(i * 2 + 1).unwrap() as usize - 48][match rings.chars().nth(i * 2).unwrap() {
                'R' => 0,
                'G' => 1,
                'B' => 2,
                _ => 0,
            }] = true;
        }
        for i in 0..10 {
            if rods[i][0] && rods[i][1] && rods[i][2] {
                result += 1;
            }
        }
        result
    }
}