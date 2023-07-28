impl Solution {
    pub fn total_strength(strength: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut stack = vec![];
        let mut right = 0;
        let mut left = 0;
        let mut min = std::i32::MAX;
        let mut last = 0;
        for (i, s) in strength.iter().enumerate() {
            right = i;
            sum += s;
            min = std::cmp::min(min, *s);
            while !stack.is_empty() && stack.last().unwrap().0 >= *s {
                let (s, l, r) = stack.pop().unwrap();
                sum -= s * (r - l + 1) as i32;
                last = l;
            }
            stack.push((*s, last, right));
            sum += *s * (right - last + 1) as i32;
            left += sum;
        }
        left
    }
}