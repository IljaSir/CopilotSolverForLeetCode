impl Solution {
    pub fn count_combinations(pieces: Vec<String>, positions: Vec<Vec<i32>>) -> i32 {
        
        let mut ans = 1;
        let mut r = 0;
        let mut c = 0;
        let mut d = 0;
        for i in 0..pieces.len() {
            let (x, y) = (positions[i][0] as i64, positions[i][1] as i64);
            match pieces[i].as_str() {
                "rook" => {
                    r += 1;
                    ans *= 15 - (x + y + 8 - x + 8 - y);
                },
                "bishop" => {
                    d += 1;
                    ans *= 15 - (x + y + x + 8 - y);
                },
                "queen" => {
                    c += 1;
                    ans *= 15 - (x + y + 8 - x + 8 - y + x + y + x + 8 - y);
                },
                _ => (),
            }
        }
        ans * 2i64.pow(r) * 2i64.pow(c) * 2i64.pow(d)
    }
}