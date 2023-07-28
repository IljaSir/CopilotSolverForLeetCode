impl Solution {
    pub fn number_of_beams(bank: Vec<String>) -> i32 {
        
        let mut res = 0;
        let mut prev = vec![0; bank[0].len()];
        for row in bank {
            let mut cur = vec![0; row.len()];
            for (j, c) in row.chars().enumerate() {
                if c == '1' {
                    cur[j] = 1;
                    for k in 0..j {
                        if prev[k] == 1 {
                            res += 1;
                        }
                    }
                }
            }
            prev = cur;
        }
        res
    }
}