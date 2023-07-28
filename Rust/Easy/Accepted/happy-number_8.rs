impl Solution {
    pub fn is_happy(n: i32) -> bool {
        
        let mut num = n;
        let mut set = std::collections::HashSet::new();
        loop {
            let mut new_num = 0;
            while num > 0 {
                let d = num % 10;
                new_num += d * d;
                num /= 10;
            }
            if new_num == 1 {
                return true;
            }
            if set.contains(&new_num) {
                return false;
            }
            set.insert(new_num);
            num = new_num;
        }
    }
}