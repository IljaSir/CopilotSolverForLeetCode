impl Solution {
    pub fn reordered_power_of2(n: i32) -> bool {
        
        let mut count = [0; 10];
        let mut n = n;
        while n > 0 {
            count[(n % 10) as usize] += 1;
            n /= 10;
        }
        for i in 0..30 {
            let mut tmp = [0; 10];
            let mut j = 1 << i;
            while j > 0 {
                tmp[(j % 10) as usize] += 1;
                j /= 10;
            }
            if count == tmp {
                return true;
            }
        }
        false
    }
}