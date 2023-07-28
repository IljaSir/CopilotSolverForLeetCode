impl Solution {
    pub fn get_smallest_string(n: i32, k: i32) -> String {
        
        let mut res = vec!['a'; n as usize];
        let mut k = k - n;
        let mut i = n - 1;
        while k > 0 {
            let add = k.min(25);
            res[i as usize] = (res[i as usize] as u8 + add) as char;
            i -= 1;
            k -= add;
        }
        res.iter().collect()
    }
}