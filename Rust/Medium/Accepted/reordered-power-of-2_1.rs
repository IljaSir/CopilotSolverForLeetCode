impl Solution {
    pub fn reordered_power_of2(n: i32) -> bool {
        
        let mut n = n;
        let mut count = vec![0; 10];
        while n > 0 {
            count[(n % 10) as usize] += 1;
            n /= 10;
        }
        for i in 0..32 {
            let mut m = 1 << i;
            let mut count2 = vec![0; 10];
            while m > 0 {
                count2[(m % 10) as usize] += 1;
                m /= 10;
            }
            if count == count2 {
                return true;
            }
        }
        false
    }
}