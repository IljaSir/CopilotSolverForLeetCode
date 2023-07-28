impl Solution {
    pub fn minimum_swap(s1: String, s2: String) -> i32 {
        
        let mut count_x = 0;
        let mut count_y = 0;
        let mut result = 0;
        for (c1, c2) in s1.chars().zip(s2.chars()) {
            match (c1, c2) {
                ('x', 'y') => count_x += 1,
                ('y', 'x') => count_y += 1,
                _ => (),
            }
        }
        result += count_x / 2 + count_y / 2;
        if count_x % 2 != count_y % 2 {
            return -1;
        }
        if count_x % 2 == 1 {
            result += 2;
        }
        result
    }
}