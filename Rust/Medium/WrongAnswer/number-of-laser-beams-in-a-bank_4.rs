impl Solution {
    pub fn number_of_beams(bank: Vec<String>) -> i32 {
        
        let mut ans = 0;
        let mut a = vec![0; bank[0].len()];
        for i in 0..bank.len() {
            let mut b = vec![0; bank[0].len()];
            for j in 0..bank[0].len() {
                if bank[i].chars().nth(j).unwrap() == '1' {
                    for k in 0..bank[0].len() {
                        if a[k] == 1 {
                            b[k] = 1;
                        }
                    }
                    b[j] = 1;
                }
            }
            a = b;
            ans += a.iter().sum::<i32>();
        }
        ans
    }
}