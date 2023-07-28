impl Solution {
    pub fn get_smallest_string(n: i32, k: i32) -> String {
        
        let mut res = vec!['a'; n as usize];
        let mut k = k - n;
        let mut i = n - 1;
        while k > 0 {
            if k >= 25 {
                res[i as usize] = 'z';
                k -= 25;
            } else {
                res[i as usize] = (b'a' + k as u8) as char;
                k = 0;
            }
            i -= 1;
        }
        res.iter().collect()
    }
}