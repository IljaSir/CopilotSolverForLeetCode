impl Solution {
    pub fn count_special_numbers(n: i32) -> i32 {
        
        let mut count = 0;
        for i in 1..=n {
            let mut set = std::collections::HashSet::new();
            let mut x = i;
            while x > 0 {
                set.insert(x % 10);
                x /= 10;
            }
            if set.len() == (i as f64).log10().floor() as usize + 1 {
                count += 1;
            }
        }
        count
    }
}