impl Solution {
    pub fn count_points(rings: String) -> i32 {
        
        let mut res = 0;
        let mut map = vec![vec![0; 3]; 10];
        for i in 0..rings.len() {
            if i % 2 == 0 {
                let c = match rings.as_bytes()[i] {
                    b'R' => 0,
                    b'G' => 1,
                    b'B' => 2,
                    _ => 0,
                };
                let idx = (rings.as_bytes()[i + 1] - b'0') as usize;
                map[idx][c] += 1;
            }
        }
        for i in 0..10 {
            if map[i][0] > 0 && map[i][1] > 0 && map[i][2] > 0 {
                res += 1;
            }
        }
        res
    }
}