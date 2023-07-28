impl Solution {
    pub fn nums_same_consec_diff(n: i32, k: i32) -> Vec<i32> {
        
        let mut result = vec![0; 1];
        for i in 1..n {
            let mut new_result = vec![];
            for j in 0..result.len() {
                let mut last = result[j] % 10;
                if last + k < 10 {
                    new_result.push(result[j] * 10 + last + k);
                }
                if k != 0 && last >= k {
                    new_result.push(result[j] * 10 + last - k);
                }
            }
            result = new_result;
        }
        if n == 1 {
            result.push(0);
        }
        result
    }
}