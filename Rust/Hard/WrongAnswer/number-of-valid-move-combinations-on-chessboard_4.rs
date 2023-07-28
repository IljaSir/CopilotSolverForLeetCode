impl Solution {
    pub fn count_combinations(pieces: Vec<String>, positions: Vec<Vec<i32>>) -> i32 {
        
        let mut result = 1;
        for i in 0..pieces.len() {
            match pieces[i].as_str() {
                "rook" => result *= 14 + 1,
                "queen" => result *= 21 + 1,
                "bishop" => result *= 12 + 1,
                _ => (),
            }
        }
        result - 1
    }
}