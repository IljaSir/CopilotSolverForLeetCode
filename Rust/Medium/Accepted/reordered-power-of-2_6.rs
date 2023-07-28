impl Solution {
    pub fn reordered_power_of2(n: i32) -> bool {
        
        let mut n = n.to_string().into_bytes();
        n.sort();
        let mut i = 1;
        while i <= 1_000_000_000 {
            let mut j = i.to_string().into_bytes();
            j.sort();
            if n == j {
                return true;
            }
            i *= 2;
        }
        false
    }
}