impl Solution {
    pub fn sum_of_three(num: i64) -> Vec<i64> {
        
        let mut ans = Vec::new();
        for i in 1..num {
            if num - i * (i + 1) / 2 <= 0 {
                break;
            }
            if (num - i * (i + 1) / 2) % i == 0 {
                let mut tmp = Vec::new();
                let mut j = (num - i * (i + 1) / 2) / i;
                for k in 0..i {
                    tmp.push(j + k);
                }
                ans = tmp;
            }
        }
        ans
    }
}