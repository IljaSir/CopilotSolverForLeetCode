impl Solution {
    pub fn max_number_of_balloons(text: String) -> i32 {
        
        let mut count = [0; 26];
        for c in text.chars() {
            count[c as usize - 'a' as usize] += 1;
        }
        let mut res = i32::max_value();
        let map = [('b', 1), ('a', 1), ('l', 2), ('o', 2), ('n', 1)];
        for (c, n) in map.iter() {
            res = res.min(count[*c as usize - 'a' as usize] / n);
        }
        res
    }
}