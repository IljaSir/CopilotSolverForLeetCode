impl Solution {
    pub fn get_smallest_string(n: i32, k: i32) -> String {
        
        let mut result = vec!['a'; n as usize];
        let mut k = k - n;
        let mut i = n - 1;
        while k > 0 {
            let x = std::cmp::min(k, 25) as u8;
            result[i as usize] = (result[i as usize] as u8 + x) as char;
            k -= x as i32;
            i -= 1;
        }
        result.iter().collect()
    }
}