impl Solution {
    pub fn min_characters(a: String, b: String) -> i32 {
        
        let mut a = a.as_bytes();
        let mut b = b.as_bytes();
        let mut a_count = vec![0; 26];
        let mut b_count = vec![0; 26];
        for i in 0..a.len() {
            a_count[(a[i] - b'a') as usize] += 1;
        }
        for i in 0..b.len() {
            b_count[(b[i] - b'a') as usize] += 1;
        }
        let mut result = i32::MAX;
        for i in 0..26 {
            let mut count = 0;
            for j in 0..i {
                count += a_count[j] + b_count[j];
            }
            result = result.min(count);
        }
        for i in 0..26 {
            let mut count = 0;
            for j in i+1..26 {
                count += a_count[j] + b_count[j];
            }
            result = result.min(count);
        }
        for i in 0..26 {
            result = result.min(a.len() as i32 + b.len() as i32 - a_count[i] as i32 - b_count[i] as i32);
        }
        result
    }
}