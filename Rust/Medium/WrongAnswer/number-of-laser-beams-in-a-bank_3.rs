impl Solution {
    pub fn number_of_beams(bank: Vec<String>) -> i32 {
        
        let mut result = 0;
        let mut is_beam = false;
        for i in 0..bank[0].len() {
            for j in 0..bank.len() {
                if bank[j].chars().nth(i).unwrap() == '1' {
                    if is_beam {
                        result += 1;
                    }
                    is_beam = !is_beam;
                }
            }
        }
        return result;
    }
}