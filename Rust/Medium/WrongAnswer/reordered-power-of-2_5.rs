impl Solution {
    pub fn reordered_power_of2(n: i32) -> bool {
        
        let mut n = n;
        let mut digits = vec![];
        while n > 0 {
            digits.push(n % 10);
            n /= 10;
        }
        digits.sort();
        let mut i = 0;
        while i < 31 {
            let mut j = i;
            let mut digits2 = vec![];
            while j > 0 {
                digits2.push(j % 2);
                j /= 2;
            }
            digits2.sort();
            if digits == digits2 {
                return true;
            }
            i += 1;
        }
        false
    }
}